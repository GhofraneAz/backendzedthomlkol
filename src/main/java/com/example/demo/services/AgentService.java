package com.example.demo.services;

import com.example.demo.entities.Agent;
import java.util.List;

public interface AgentService {
    Agent createAgent(Agent agent);
    Agent getAgentById(Long id);
    List<Agent> getAllAgents();
    Agent updateAgent(Agent agent);
    void deleteAgent(Long id);
}
