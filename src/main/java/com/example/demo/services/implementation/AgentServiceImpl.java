package com.example.demo.services.implementation;

import com.example.demo.entities.Agent;
import com.example.demo.repository.AgentRepository;
import com.example.demo.services.AgentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    public List<Agent> SearchFilter(Agent agent) {
        Specification<Agent> spec = new Specification<Agent>() {
            @Override
            public Predicate toPredicate(Root<Agent> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();

                // Vérifiez que la casse correspond à celle de l'entité
                if (agent.getCodeDistrict() != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codeDistrict"), agent.getCodeDistrict()));
                }
                if (agent.getCodeFonction() != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codeFonction"), agent.getCodeFonction()));
                }
                if (agent.getNom() != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("nom"), agent.getNom()));  // Correction ici si "nom" au lieu de "Nom"
                }
                if (agent.getPrenom() != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("prenom"), agent.getPrenom()));
                }
                if (agent.getCodeEtatAgent() != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codeEtatAgent"), agent.getCodeEtatAgent()));
                }
                if (agent.getNumTampon() != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("numTampon"), agent.getNumTampon()));
                }
                if (agent.getBureauAffectation() != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("bureauAffectation"), agent.getBureauAffectation()));
                }

                return predicate;
            }
        };
        
        return agentRepository.findAll(spec);
    }

    @Override
    public Agent updateAgent(Agent agent) {
        Optional<Agent> existingAgentOptional = agentRepository.findById(agent.getId());
        if (existingAgentOptional.isPresent()) {
            Agent existingAgent = existingAgentOptional.get();

            // Mise à jour des propriétés de l'agent
            existingAgent.setCodeDistrict(agent.getCodeDistrict());
            existingAgent.setCodeFonction(agent.getCodeFonction());
            existingAgent.setNom(agent.getNom());
            existingAgent.setPrenom(agent.getPrenom());
            existingAgent.setCodeEtatAgent(agent.getCodeEtatAgent());
            existingAgent.setNumTampon(agent.getNumTampon());
            existingAgent.setBureauAffectation(agent.getBureauAffectation());

            return agentRepository.save(existingAgent);
        }
        return null; // Agent non trouvé
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
