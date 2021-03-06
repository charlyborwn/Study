package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;

public class DriverMapper
{
    public static DriverDO makeDriverDO(DriverDTO driverDTO)
    {
        return new DriverDO(driverDTO.getUsername(), driverDTO.getPassword());
    }


    public static DriverDO makeDriverDOUI(DriverDTO driverDTO)
    {
        return new DriverDO(
            driverDTO.getId(), driverDTO.getUsername(), driverDTO.getPassword(), driverDTO.getCoordinate(), driverDTO.getDeleted(), driverDTO.getOnlineStatus(),
            driverDTO.getCarSelectedId());
    }


    public static DriverDTO makeDriverDTO(DriverDO driverDO)
    {
        DriverDTO.DriverDTOBuilder driverDTOBuilder =
            DriverDTO
                .newBuilder()
                .setId(driverDO.getId())
                .setPassword(driverDO.getPassword())
                .setUsername(driverDO.getUsername())
                .setDeleted(driverDO.getDeleted())
                .setOnlineStatus(driverDO.getOnlineStatus())
                .setCarSelectedId(driverDO.getCarSelectedId());

        GeoCoordinate coordinate = driverDO.getCoordinate();
        if (coordinate != null)
        {
            driverDTOBuilder.setCoordinate(coordinate);
        }

        return driverDTOBuilder.createDriverDTO();
    }


    public static List<DriverDTO> makeDriverDTOList(Collection<DriverDO> drivers)
    {
        return drivers
            .stream()
            .map(DriverMapper::makeDriverDTO)
            .collect(Collectors.toList());
    }


    public static DriverDTO makeEmptyDriverDTO()
    {
        DriverDTO.DriverDTOBuilder driverDTOBuilder = DriverDTO.newBuilder();
        return driverDTOBuilder.createDriverDTO();
    }
}
