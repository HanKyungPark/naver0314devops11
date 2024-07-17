package bit.mycar.repository;

import bit.mycar.data.MycarDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCarDaoInter extends JpaRepository<MycarDto, Long> {
}
