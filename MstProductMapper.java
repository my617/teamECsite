package jp.co.internous.angular.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.angular.model.domain.MstProduct;

@Mapper
public interface MstProductMapper {

	@Select("SELECT * FROM mst_product")
	List<MstProduct> findAll();

	@Select("SELECT * FROM mst_product WHERE id = #{productId}")
	MstProduct findProduct(@Param("productId") String productId);

	List<MstProduct> findByProductName(@Param("productName") String productName);

	List<MstProduct> findByCategoryIdAndProductName(
		@Param("categoryId") int categoryId, 
		@Param("productName") String productName);

	@Select("SELECT * FROM mst_product WHERE category_id = #{categoryId}")
	List<MstProduct> findByCategoryId(@Param("categoryId") int categoryId);

}


