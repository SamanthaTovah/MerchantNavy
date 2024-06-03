package io.github.samanthatovah.merchantnavy.domain.popinstallationdemand;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class PopInstallationDemandService {

	private final PopInstallationDemandRepository repository;

	public List<PopInstallationDemand> getAll() {
		return repository.getAll();
	}
}
