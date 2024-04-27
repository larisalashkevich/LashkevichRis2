package com.lashkevich;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hotels")
public class HotelServlet extends HttpServlet {
    @EJB
    private HotelBean hotelBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in get method");
        String availability = request.getParameter("availability");
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        double minPrice;
        double maxPrice;
        try {
            minPrice = Double.parseDouble(minPriceStr);
            maxPrice = Double.parseDouble(maxPriceStr);
        } catch (NumberFormatException ex) {
            minPrice = Double.MIN_VALUE;
            maxPrice = Double.MAX_VALUE;
        }

        request.setAttribute("hotels", hotelBean.getHotelsByPriceAndAvailable(minPrice, maxPrice, availability));
        getServletContext().getRequestDispatcher("/hotel.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotelId = request.getParameter("id");
        hotelBean.deleteHotelById(Integer.parseInt(hotelId));
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        response.sendRedirect(request.getContextPath());
    }

}