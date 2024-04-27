package com.lashkevich;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class HotelFormServlet extends HttpServlet {
    @EJB
    private HotelBean hotelBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hotels", hotelBean.getAllHotels());
        getServletContext().getRequestDispatcher("/hotel_form.jsp").forward(request, response);
    }
}
