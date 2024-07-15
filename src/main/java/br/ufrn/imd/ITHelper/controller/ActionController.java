package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Action;
import br.ufrn.imd.ITHelper.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/acao")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @PostMapping
    public ResponseEntity<Action> createAction(@RequestBody Action action) {
        if (action.getDataHoraAcao() == null) {
            action.setDataHoraAcao(new Timestamp(System.currentTimeMillis()));
        }

        Action newAction = actionService.saveAction(action);
        return ResponseEntity.ok(newAction);
    }

    // Add other controller methods if needed
}

