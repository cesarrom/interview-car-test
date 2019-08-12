package com.ctest.models.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.ctest.models.SoldCar;
import com.ctest.utils.ObjectUtils;

import io.swagger.annotations.ApiModelProperty;

//@Builder
public class SoldCarDto extends CommonModelDto {
	@NonNull
	private Long carId;
	@NonNull
	private List<Long> carOptionIds;
	@Nullable
	@ApiModelProperty(hidden= true)
	private BaseCarDto car;
	@Nullable
	@ApiModelProperty(hidden= true)
	private List<CarOptionDto> carOptions;
	private Double price;
	private String name;

	public SoldCarDto() {
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public SoldCar getCrudModel() {
		SoldCar res = new SoldCar();
		BeanUtils.copyProperties(this, res);
		if(ObjectUtils.isThruthy(this.car)) {
			res.setCar(this.car.getCrudModel());
		}
		if (ObjectUtils.isThruthy(this.carOptions)) {
			res.setCarOptions(this.carOptions.stream().map((value) -> {
				return value.getCrudModel();
			}).collect(Collectors.toList()));
		}
		return res;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public List<Long> getCarOptionIds() {
		return carOptionIds;
	}

	public void setCarOptionIds(List<Long> carOptionIds) {
		this.carOptionIds = carOptionIds;
	}

	public BaseCarDto getCar() {
		return car;
	}

	public void setCar(BaseCarDto car) {
		this.car = car;
	}

	public List<CarOptionDto> getCarOptions() {
		return carOptions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCarOptions(List<CarOptionDto> carOptions) {
		this.carOptions = carOptions;
	}

}
