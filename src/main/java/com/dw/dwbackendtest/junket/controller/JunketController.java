package com.dw.dwbackendtest.junket.controller;

import com.dw.dwbackendtest.common.dto.MultiResponseDto;
import com.dw.dwbackendtest.common.dto.SingleResponseDto;
import com.dw.dwbackendtest.junket.dto.JunketDto;
import com.dw.dwbackendtest.junket.entity.JunketEntity;
import com.dw.dwbackendtest.junket.mapper.JunketMapper;
import com.dw.dwbackendtest.junket.service.JunketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/junket")
@Validated
@Slf4j
public class JunketController {
    private final JunketService junketService;
    private final JunketMapper junketMapper;

    public JunketController(JunketService junketService,
                            JunketMapper junketMapper) {
        this.junketService = junketService;
        this.junketMapper = junketMapper;
    }

    @PostMapping
    public ResponseEntity postJunket(@Valid @RequestBody JunketDto.Post junketPostDto) {
        JunketEntity junket = junketService.createJunket(junketPostDto);
        JunketDto.Response response = junketMapper.junketToJunketResponse(junket);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getJunkets(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<JunketEntity> pageJunkets = junketService.findJunkets(page - 1, size);
        List<JunketEntity> junkets = pageJunkets.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(junketMapper.junketsToJunketsResponse(junkets), pageJunkets),
                HttpStatus.OK
        );
    }

    @PatchMapping
    public ResponseEntity patchJunkets(@RequestBody JunketDto.Patch junketPatchDto){
        JunketEntity result = junketService.updateJunket(junketPatchDto);
        return new ResponseEntity<>(
                new SingleResponseDto<>(result),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/{junketId}")
    public void deleteJunkets(@PathVariable("junketId") Long junketId ){
                junketService.deleteJunket(junketId);
    }
}
