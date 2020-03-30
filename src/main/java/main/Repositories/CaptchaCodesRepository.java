package main.Repositories;

import main.model.CaptchaCodes;
import org.springframework.data.repository.CrudRepository;

public interface CaptchaCodesRepository extends CrudRepository<CaptchaCodes, Integer> {
}
