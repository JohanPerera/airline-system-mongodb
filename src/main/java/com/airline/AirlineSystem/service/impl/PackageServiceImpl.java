package com.airline.AirlineSystem.service.impl;

import com.airline.AirlineSystem.entity.Package;
import com.airline.AirlineSystem.repository.PakageRepository;
import com.airline.AirlineSystem.service.PackageService;
import com.airline.AirlineSystem.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    PakageRepository pakageRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public PackageServiceImpl() {
        super();
    }


    @Override
    public List<Package> getAllPackages() {
        return pakageRepository.findAll();
    }

    @Override
    public Package addPackage(Package pakage) {
        pakage.setId(sequenceGeneratorService.generateSequence(Package.SEQUENCE_NAME));
        return pakageRepository.save(pakage);
    }

    @Override
    public void deletePackage(Long id) {
        pakageRepository.deleteById(id);
    }

    @Override
    public Package updatePackage(Package pakage) {
        return pakageRepository.save(pakage);
    }

    @Override
    public Package getPackageById(Long id) {
        return pakageRepository.findById(id).get();
    }

}
