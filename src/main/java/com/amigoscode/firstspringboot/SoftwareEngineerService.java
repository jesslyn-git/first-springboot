package com.amigoscode.firstspringboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineer() {
        return softwareEngineerRepository.findAll(); // usually in this step should be .stream and .map into a class that can be exposed to client, such as remove password
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " not found"
                ));
    }

    public void deleteSoftwareEngineer(Integer id) {
        SoftwareEngineer softwareEngineer = this.getSoftwareEngineerById(id);
        softwareEngineerRepository.delete(softwareEngineer);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer updateSoftwareEngineer) {
        SoftwareEngineer matchSoftwareEngineer = this.getSoftwareEngineerById(id);
        matchSoftwareEngineer.setName(updateSoftwareEngineer.getName());
        matchSoftwareEngineer.setTechStack(updateSoftwareEngineer.getTechStack());
        softwareEngineerRepository.save(matchSoftwareEngineer);
    }
}
