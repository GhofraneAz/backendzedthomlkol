package com.example.demo.controllers;

import com.example.demo.entities.Agent;
import com.example.demo.services.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@AllArgsConstructor
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/createAgent")
    // http://localhost:8080/api/agents
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        Agent savedAgent = agentService.createAgent(agent);
        return new ResponseEntity<>(savedAgent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    // http://localhost:8080/api/agents/1
    public ResponseEntity<Agent> getAgentById(@PathVariable("id") Long agentId) {
        Agent agent = agentService.getAgentById(agentId);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @GetMapping("/getAllAgents")
    // http://localhost:8080/api/agents
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agentList = agentService.getAllAgents();
        return new ResponseEntity<>(agentList, HttpStatus.OK);
    }

    @PutMapping("/updateAgent/{id}")
    // http://localhost:8080/api/agents/1
    public ResponseEntity<Agent> updateAgent(@PathVariable("id") Long agentId, @RequestBody Agent agent) {
        agent.setId(agentId);
        Agent updatedAgent = agentService.updateAgent(agent);
        return new ResponseEntity<>(updatedAgent, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAgent/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable Long id) {
        try {
            agentService.deleteAgent(id);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "Agent supprimé avec succès"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
    @PostMapping("/Search")
    // http://localhost:8080/api/agents
    public ResponseEntity<List<Agent>> Search(@RequestBody Agent agent) {
        List<Agent> agentList = agentService.SearchFilter(agent);
        return new ResponseEntity<>(agentList, HttpStatus.OK);
    }
}
