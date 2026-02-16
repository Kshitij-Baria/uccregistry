package com.kshitijbaria.uccregistry.service;

import com.kshitijbaria.uccregistry.model.AmendmentDetails;
import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.dto.request.CreateAmendmentDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateAmendmentDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.response.AmendmentDetailsResponse;
import com.kshitijbaria.uccregistry.repository.AmendmentDetailsRepository;
import com.kshitijbaria.uccregistry.service.mapper.AmendmentDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class AmendmentDetailsService {
    private final AmendmentDetailsRepository amendmentDetailsRepository;
    private final AmendmentDetailsMapper amendmentDetailsMapper;

    @Autowired()
    public AmendmentDetailsService(AmendmentDetailsRepository amendmentDetailsRepository, AmendmentDetailsMapper amendmentDetailsMapper) {
        this.amendmentDetailsRepository = amendmentDetailsRepository;
        this.amendmentDetailsMapper = amendmentDetailsMapper;
    }

    public List<AmendmentDetails> findAll() {
        return amendmentDetailsRepository.findAll();
    }

    public AmendmentDetails findById(long id) {
        return amendmentDetailsRepository.findById(id).orElse(null);
    }

    public AmendmentDetailsResponse save(AmendmentDetails amendmentDetails) {
        // amendmentDetails = amendmentDetailsRepository.save(amendmentDetails);
        return amendmentDetailsMapper.toResponse(amendmentDetails);
    }

    public AmendmentDetailsResponse save(CreateAmendmentDetailsRequest createAmendmentDetailsRequest, UCCFiling filing) {
        AmendmentDetails amendmentDetails = amendmentDetailsMapper.toEntity(createAmendmentDetailsRequest, filing);
        return save(amendmentDetails);
    }

    public AmendmentDetailsResponse update(UpdateAmendmentDetailsRequest updateAmendmentDetailsRequest) {
        AmendmentDetails amendmentDetails = amendmentDetailsMapper.toEntity(updateAmendmentDetailsRequest, findById(updateAmendmentDetailsRequest.getId()));
        return save(amendmentDetails);
    }

    public List<AmendmentDetailsResponse> saveAll(List<AmendmentDetails> amendmentDetailsList) {
        // amendmentDetailsList = amendmentDetailsRepository.saveAll(amendmentDetailsList);
        return amendmentDetailsList.stream()
                .map(amendmentDetailsMapper::toResponse)
                .toList();
    }

    public List<AmendmentDetailsResponse> saveAll(List<CreateAmendmentDetailsRequest> createAmendmentDetailsRequestList, UCCFiling filing) {
        List<AmendmentDetails> amendmentDetails = createAmendmentDetailsRequestList.stream()
                .map(createAmendmentDetailsRequest -> amendmentDetailsMapper.toEntity(createAmendmentDetailsRequest, filing))
                .toList();
        return saveAll(amendmentDetails);
    }

    public List<AmendmentDetailsResponse> updateAll(List<UpdateAmendmentDetailsRequest> updateAmendmentDetailsRequestList) {
        List<AmendmentDetails> amendmentDetails = updateAmendmentDetailsRequestList.stream()
                .map(updateAmendmentDetailsRequest -> amendmentDetailsMapper.toEntity(updateAmendmentDetailsRequest, findById(updateAmendmentDetailsRequest.getId())))
                .toList();
        return saveAll(amendmentDetails);
    }
}
