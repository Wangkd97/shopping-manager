package com.neuedu.dao;

import com.neuedu.pojo.Order;
import com.neuedu.vo.pageVo;

import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_order
     *
     * @mbggenerated
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_order
     *
     * @mbggenerated
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_order
     *
     * @mbggenerated
     */
    List<Order> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Order record);
    int alterStatus(Long orderNo);
    List<Order> selectfenye(pageVo pageVo);
    int selectcount();
    List<Order> selectfahuo(pageVo pageVo);
    int selectfahuocount();
    Order selectByNo(Long no);
    int cancelOrder(Long no);
}