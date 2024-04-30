package com.example.finalproject.domain.orderHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;

    // 브랜드 별 사용자가 구매한 아이템 주문 목록
    public List<OrderHistoryResponse.orderListDTO> findByOrderHistoryItemsAdmin(Integer adminId) {
        List<OrderHistory> orderHistoryList = orderHistoryRepository.findByOrderHistoryItemsAdmin(adminId);
        return orderHistoryList.stream().map(orderHistory -> new OrderHistoryResponse.orderListDTO(orderHistory, orderHistory.getOrder().getUser(), orderHistory.getItems())).toList();
    }
}