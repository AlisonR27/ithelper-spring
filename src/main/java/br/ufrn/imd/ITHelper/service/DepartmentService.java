package br.ufrn.imd.ITHelper.service;


import br.ufrn.imd.ITHelper.model.Department;
import br.ufrn.imd.ITHelper.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        return departmentOptional.orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existingDepartmentOptional = departmentRepository.findById(id);

        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();

            // Atualizar os campos necessários
            existingDepartment.setNomeDepartamento(updatedDepartment.getNomeDepartamento());
            // Adicione outros campos conforme necessário

            return departmentRepository.save(existingDepartment);
        } else {
            return null;
        }
    }

    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}


