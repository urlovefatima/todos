package sn.ept.git.seminaire.cicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TodoApplicationTest {


	// TEST GITLEAKS
	String testSecret = "ghp_FAKE123456789012345678901234567890123456";

	@Autowired
	ApplicationContext ctx;

	@Test
	void contextLoads() {
		assertThat(ctx).isNotNull();
	}


}
