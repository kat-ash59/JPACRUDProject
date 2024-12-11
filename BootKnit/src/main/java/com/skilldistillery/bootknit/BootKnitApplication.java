package com.skilldistillery.bootknit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.skilldistillery.jpaKatsKnittingStuff")
@SpringBootApplication
public class BootKnitApplication 
{

	
	public static void main(String[] args) 
	{
		SpringApplication.run(BootKnitApplication.class, args);
	}

}
