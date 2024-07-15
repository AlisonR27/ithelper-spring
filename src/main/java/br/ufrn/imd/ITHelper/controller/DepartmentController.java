package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Department;
import br.ufrn.imd.ITHelper.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        Department department = departmentService.updateDepartment(id, updatedDepartment);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        if (departmentService.deleteDepartment(id)) {
            return ResponseEntity.ok("Departamento com id " + id + " excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

