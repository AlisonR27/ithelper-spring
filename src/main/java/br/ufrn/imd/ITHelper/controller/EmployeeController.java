package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.exception.UserNotFoundException;
import br.ufrn.imd.ITHelper.model.Employee;
import br.ufrn.imd.ITHelper.model.User;
import br.ufrn.imd.ITHelper.repository.UserRepository;
import br.ufrn.imd.ITHelper.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final UserRepository userRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, UserRepository userRepository, UserRepository userRepository1) {
        this.employeeService = employeeService;
        this.userRepository = userRepository1;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getFuncionarioById(@PathVariable Long id) {
        Employee funcionario = employeeService.getEmployeeById(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> createFuncionario(@RequestBody Employee employee) {
        // Supondo que o ID do User esteja presente no Employee
        String userId = String.valueOf(employee.getUsuario().getId());


        // Encontrar o User pelo ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        // Verifica se o User existe
        if (user != null) {
            // Associa o User ao Employee
            employee.setUsuario(user);

            // Agora persiste o Employee
            Employee createdEmployee = employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
        }
        return null;
    }



    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateFuncionario(@PathVariable Long id, @RequestBody Employee updatedFuncionario) {
        Employee funcionario = employeeService.updateEmployee(id, updatedFuncionario);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
        boolean deleted = employeeService.deleteFuncionario(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Funcionario com id " + id + " excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
