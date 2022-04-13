package com.cooper.springdatajpa.ui;

import com.cooper.springdatajpa.application.EmployeeService;
import com.cooper.springdatajpa.dto.ExistEmployeeResponseDTO;
import com.cooper.springdatajpa.dto.LookupEmployeeResponseDTO;
import com.cooper.springdatajpa.ui.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LookupEmployeeResponseDTO>> getEmployee(@PathVariable Long id) {
        LookupEmployeeResponseDTO lookupEmployeeResponseDTO = employeeService.findById(id);
        return ResponseEntity.ok().body(ApiResponse.create(lookupEmployeeResponseDTO));
    }

    @GetMapping("/{id}/exist")
    public ResponseEntity<ApiResponse<ExistEmployeeResponseDTO>> existsEmployee(@PathVariable Long id) {
        ExistEmployeeResponseDTO existEmployeeResponseDTO = employeeService.exists(id);
        return ResponseEntity.ok().body(ApiResponse.create(existEmployeeResponseDTO));
    }

}
