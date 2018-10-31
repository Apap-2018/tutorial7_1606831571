package com.apap.tutorial4.service;
import java.util.List;
import java.util.Optional;
import com.apap.tutorial4.model.DealerModel;


public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	DealerModel addDealer(DealerModel dealer);
	List<DealerModel> getAll();
	void updateDealer(Long id, String alamat, String noTelp);
	void deleteDealer(DealerModel dealer);
	List<DealerModel> viewAllDealer();
	void dealerUpdate(DealerModel updateDealer, Long dealerId);

}
