package fr.sii.sonar.coverage.lcov.factory;

import java.io.File;
import java.io.IOException;

import fr.sii.sonar.coverage.lcov.provider.LcovProvider;
import fr.sii.sonar.report.core.common.exception.CreateException;
import fr.sii.sonar.report.core.common.factory.ProviderFactory;
import fr.sii.sonar.report.core.common.provider.Provider;
import fr.sii.sonar.report.core.coverage.domain.CoverageReport;

/**
 * Factory that creates instance of {@link LcovProvider} for the provided LCOV file
 * 
 * @author Aurélien Baudet
 *
 */
public class LcovProviderFactory implements ProviderFactory<CoverageReport> {

	public Provider<CoverageReport> create(File reportFile) throws CreateException {
		try {
			return new LcovProvider(reportFile);
		} catch (IOException e) {
			throw new CreateException("failed to parse lcov file", e);
		}
	}

}
