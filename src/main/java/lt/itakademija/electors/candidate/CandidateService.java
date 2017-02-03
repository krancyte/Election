package lt.itakademija.electors.candidate;

import lt.itakademija.electors.county.CountyEntity;
import lt.itakademija.electors.county.CountyService;
import lt.itakademija.electors.party.PartyEntity;
import lt.itakademija.electors.party.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pavel on 2017-01-12.
 */
@Service
public class CandidateService {

    @Autowired
    CandidateRepository repository;

    @Autowired
    PartyService partyService;

    @Autowired
    CountyService countyService;

    @Transactional
    public CandidateEntity save(CandidateEntity can) {
        return repository.save(mapCounty(can));
    }

    public List<CandidateReport> getAllCandidates() {
        return repository.getCandidatesList().stream().map(can -> new CandidateReport(can)).collect(Collectors.toList());
    }

    public CandidateEntity findByIdEntity(Long id){
        return repository.finById(id);
    }

    @Transactional
    public boolean delete(Long id){
        return repository.delete(id);
    }

    @Transactional
    public boolean deleteCandidatesByPartyId(Long id) {
        PartyEntity partyEntity = partyService.getPartyEntityById(id);
        List<CandidateReport> candidates = partyService.getPartyById(id).getMembers();
        partyService.detach(partyEntity);
        for (CandidateReport candidate : candidates) {
            System.out.println(candidate.getId());
            repository.delete(candidate.getId());
        }
    return true;
    }

    public CandidateEntity getCandidateByNameSurnameNumberParty(CandidateEntity can){
        return repository.findByNumberInPartyNameSurnameParty(can);
    }

	public CandidateReport getCandidateById(Long id) {
		CandidateEntity candidate = repository.finById(id);
		CandidateReport report = new CandidateReport(candidate);
		return report;
	}

    private CandidateEntity mapCounty(CandidateEntity can) {
        if (can.getCounty() != null) {
            if(can.getCounty().getId() != null){
                CountyEntity county = countyService.getCountyByIdCountyEnt(can.getCounty().getId());
                can.setCounty(county);
            } else {
                can.setCounty(null);
            }
            return can;
        } else {
            return can;
        }
    }
}
