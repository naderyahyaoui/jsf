package service;

import java.util.List;

import javax.ejb.Local;

import domain.Sponsor;




@Local
public interface SponsorServiceLocal {

Sponsor createSponsor(Sponsor sponsor);
void saveSponsor(Sponsor sponsor);
void removeSponsor(Sponsor sponsor);
List<Sponsor> findAllSponsors();

}
