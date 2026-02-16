package com.kshitijbaria.uccregistry.service;

import com.kshitijbaria.uccregistry.model.CollateralDetails;
import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.dto.request.CreateCollateralDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateCollateralDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.response.CollateralDetailsResponse;
import com.kshitijbaria.uccregistry.repository.CollateralDetailsRepository;
import com.kshitijbaria.uccregistry.repository.PartyDetailsRepository;
import com.kshitijbaria.uccregistry.service.mapper.CollateralDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class CollateralDetailsService {
    private final CollateralDetailsRepository collateralDetailsRepository;
    private final CollateralDetailsMapper collateralDetailsMapper;

    @Autowired()
    public CollateralDetailsService(CollateralDetailsRepository collateralDetailsRepository) {
        this.collateralDetailsRepository = collateralDetailsRepository;
        this.collateralDetailsMapper = new CollateralDetailsMapper();
    }

    public List<CollateralDetails> findAll() {
        return collateralDetailsRepository.findAll();
    }

    public CollateralDetails findById(long id) {
        return collateralDetailsRepository.findById(id).orElse(null);
    }

    public CollateralDetailsResponse save(CollateralDetails collateralDetails) {
        // collateralDetails = collateralDetailsRepository.save(collateralDetails);
        return collateralDetailsMapper.toResponse(collateralDetails);
    }

    public CollateralDetailsResponse save(CreateCollateralDetailsRequest createCollateralDetailsRequest, UCCFiling filing) {
        CollateralDetails collateralDetails = collateralDetailsMapper.toEntity(createCollateralDetailsRequest, filing                   );
        return save(collateralDetails);
    }

    public CollateralDetailsResponse update(UpdateCollateralDetailsRequest updateCollateralDetailsRequest) {
        CollateralDetails collateralDetails = collateralDetailsMapper.toEntity(updateCollateralDetailsRequest, findById(updateCollateralDetailsRequest.getId()));
        return save(collateralDetails);
    }
}
