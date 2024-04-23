package com.project.habitasse.domain.propertyDemand.repository;


import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.enums.*;
import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.security.user.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDemandRepository extends JpaRepository<PropertyDemand, Long> {

    @Query(value = "SELECT d FROM Demand d " +
            "JOIN d.propertyDemand pd " +
            "JOIN pd.address addr " +
            "WHERE d.propertyDemand.isDeleted = false " +
            "AND (:id is null or d.id = :id) " +
            "AND (:contractType is null or pd.contractType = :contractType) " +
            "AND (:propertyType is null or pd.propertyType = :propertyType) " +
            "AND (:bedroomsNumber is null or pd.bedroomsNumber = :bedroomsNumber) " +
            "AND (:furnished is null or pd.furnished = :furnished) " +
            "AND (:petFriendly is null or pd.petFriendly = :petFriendly) " +
            "AND (:suggestedValueForRent is null or pd.suggestedValueForRent = :suggestedValueForRent) " +
            "AND (:suggestedValueForSale is null or pd.suggestedValueForSale = :suggestedValueForSale) " +
            "AND (:suggestedValueForSeasonal is null or pd.suggestedValueForSeasonal = :suggestedValueForSeasonal) " +
            "AND (:state is null or addr.state = :state) " +
            "AND (:city is null or addr.city = :city) " +
            "ORDER BY d.id DESC",
            nativeQuery = false)
    Page<Demand> getFilteredDemands(
            @Param("id") Integer id,
            @Param("contractType") ContractTypeEnum contractType,
            @Param("propertyType") PropertyTypeEnum propertyType,
            @Param("bedroomsNumber") BedroomsNumberEnum bedroomsNumber,
            @Param("furnished") Boolean furnished,
            @Param("petFriendly") Boolean petFriendly,
            @Param("suggestedValueForRent") SuggestedValueForRentEnum suggestedValueForRent,
            @Param("suggestedValueForSale") SuggestedValueForSaleEnum suggestedValueForSale,
            @Param("suggestedValueForSeasonal") SuggestedValueForSeasonalEnum suggestedValueForSeasonal,
            @Param("state") String state,
            @Param("city") String city,
            Pageable pageable
    );

    @Query("SELECT COUNT(d) FROM Demand d JOIN d.propertyDemand pd WHERE pd.isDeleted = false AND d.user = :user")
    Integer countByUser(@Param("user") User user);
}
