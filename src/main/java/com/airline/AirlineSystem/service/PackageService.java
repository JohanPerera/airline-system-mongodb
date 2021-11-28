package com.airline.AirlineSystem.service;

import com.airline.AirlineSystem.entity.Package;

import java.util.List;

public interface PackageService {

    List<Package> getAllPackages();


    Package addPackage(Package Package);

    void deletePackage(Long id);

    Package updatePackage(Package pakage);

    Package getPackageById(Long id);

}
