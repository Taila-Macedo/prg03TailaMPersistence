package br.com.ifba.gerenciamento_curso_spring;

 import org.junit.jupiter.api.Test;
     import org.springframework.boot.test.context.SpringBootTest;
     import org.springframework.context.annotation.ComponentScan;
     import org.springframework.context.annotation.FilterType;


@SpringBootTest
 @ComponentScan(
    basePackages = "br.com.ifba",
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
         pattern = "br.com.ifba.curso.view.*"
         )
     )
class GerenciamentoCursoSpringApplicationTests {

	@Test
	void contextLoads() {
	}

}
