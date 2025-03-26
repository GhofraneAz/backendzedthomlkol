package com.example.demo.services.implementation;

import com.example.demo.entities.Agent;
import com.example.demo.repository.AgentRepository;
import com.example.demo.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent getAgentById(Long id) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        return optionalAgent.orElse(null);
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Agent updateAgent(Agent agent) {
        Optional<Agent> existingAgentOptional = agentRepository.findById(agent.getId());
        if (existingAgentOptional.isPresent()) {
            Agent existingAgent = existingAgentOptional.get();
            existingAgent.setCodeDistrict(agent.getCodeDistrict());
            existingAgent.setCodeFonction(agent.getCodeFonction());
            existingAgent.setNom(agent.getNom());
            existingAgent.setPrenom(agent.getPrenom());
            existingAgent.setCodeEtatAgent(agent.getCodeEtatAgent());
            existingAgent.setNumTampon(agent.getNumTampon());
            existingAgent.setBureauAffectation(agent.getBureauAffectation());
            return agentRepository.save(existingAgent);
        }
        return null;
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
