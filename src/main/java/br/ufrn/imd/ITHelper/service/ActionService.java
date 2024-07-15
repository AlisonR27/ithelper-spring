package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.Action;
import br.ufrn.imd.ITHelper.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public Action saveAction(Action action) {
        // Add business logic if needed
        return actionRepository.save(action);
    }

    // Add other service methods if needed
}
