package com.test;

import com.ftd.pi.ic.ftdpartners.webservices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpUrlConnection;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class SoapClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;


    public void call() throws Exception {
        ObjectFactory factory = new ObjectFactory();
        SubmitOrderFeed submitOrderFeed = new SubmitOrderFeed();
        JAXBElement<SubmitOrderFeed> submitOrderFeedJAXBElement = factory.createSubmitOrderFeed(submitOrderFeed);
        CreateOrderRequest createOrderRequest = factory.createCreateOrderRequest();

        CreateOrderRequest.FTDOrders.Order order = new CreateOrderRequest.FTDOrders.Order();
        CreateOrderRequest.FTDOrders ftdOrders = new CreateOrderRequest.FTDOrders();
        ftdOrders.setOrder(order);
        createOrderRequest.setFTDOrders(ftdOrders);
        submitOrderFeed.setFTDRequest(createOrderRequest);

        order.setPartnerId("FE");
        order.setPartnerOrderID("FEM000000015");
        order.setCurrencyCode("USD");

        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(new Date().getTime());
        order.setOrderDate(datatypeFactory.newXMLGregorianCalendar(gc));

        CreateOrderRequest.FTDOrders.Order.OrderTotals orderTotals = new CreateOrderRequest.FTDOrders.Order.OrderTotals();
        orderTotals.setOrderTotal("229.8");
        orderTotals.setOrderRetailPriceTotal("179.87");
        orderTotals.setOrderSalePriceTotal("162.0");
        orderTotals.setOrderShippingServiceFeeTotal("33.98");
        orderTotals.setOrderTaxTotal("15.84");


        order.setOrderTotals(orderTotals);
        CreateOrderRequest.FTDOrders.Order.BillingData billingData = new CreateOrderRequest.FTDOrders.Order.BillingData();
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setAddress1("<![CDATA[51 South Vail Ave]]>");
        billingAddress.setCity("<![CDATA[Arlington Hts]]>");
        billingAddress.setPostalCode("<![CDATA[60005]]>");
        billingAddress.setCountry("<![CDATA[]]>");
        billingAddress.setState("<![CDATA[IL]]>");
        billingData.setAddress(billingAddress);


        CreateOrderRequest.FTDOrders.Order.BillingData.Name name = new CreateOrderRequest.FTDOrders.Order.BillingData.Name();
        name.setFirstName("<![CDATA[Johny]]");
        name.setLastName("<![CDATA[Darr]]>");
        billingData.setName(name);


        BillingPhoneNumber billingPhoneNumber = new BillingPhoneNumber();
        billingPhoneNumber.setDayTimePhone("<![CDATA[9001234567]]>");
        billingPhoneNumber.setEveningPhone("<![CDATA[]]>");

        billingData.setPhoneNumber(billingPhoneNumber);
        billingData.setEmailAddress("<![CDATA[test@sodium.ftdi.com]]>");
        order.setBillingData(billingData);

        CreateOrderRequest.FTDOrders.Order.OrderItem orderItem  = new CreateOrderRequest.FTDOrders.Order.OrderItem();
        orderItem.setPartnerOrderItemID("FEM000000015-1");
        orderItem.setSKU("D12-4192_A");
        orderItem.setDeliveryEndDate("2015-03-19");
        orderItem.setDeliveryStartDate("2015-03-19");
        orderItem.setDeliveryLocationType("<![CDATA[Residential]]>");
        orderItem.setSpecialInstructions("<![CDATA[]]>");

        CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData fulfillmentData = new CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData();
        FulFillmentAddress fulFillmentAddress = new FulFillmentAddress();
        fulFillmentAddress.setAddress1("<![CDATA[300 South Riverside]]>");
        fulFillmentAddress.setCity("<![CDATA[Chicago]]>");
        fulFillmentAddress.setPostalCode("<![CDATA[60606]]>");
        fulFillmentAddress.setState("<![CDATA[IL]]>");
        fulFillmentAddress.setCountry("<![CDATA[US]]>");
        fulfillmentData.setAddress(fulFillmentAddress);

        CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData.Name fName = new CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData.Name();
        fName.setFirstName("<![CDATA[Tom]]>");
        fName.setLastName("<![CDATA[Hanks]]>");
        fulfillmentData.setName(fName);

        FulFillmentPhoneNumber fulFillmentPhoneNumber = new FulFillmentPhoneNumber();
        fulFillmentPhoneNumber.setDayTimePhone("9001234567");
        fulFillmentPhoneNumber.setEveningPhone("<![CDATA[]]>");
        fulfillmentData.setPhoneNumber(fulFillmentPhoneNumber);
        orderItem.setFulfillmentData(fulfillmentData);
        orderItem.setOccasion("<![CDATA[Congratulations]]>");

        CreateOrderRequest.FTDOrders.Order.OrderItem.GiftWrapData giftWrapData = new CreateOrderRequest.FTDOrders.Order.OrderItem.GiftWrapData();
        giftWrapData.setGiftWrapMessage("<![CDATA[Way To GO!]]>");
        orderItem.setGiftWrapData(giftWrapData);

        CreateOrderRequest.FTDOrders.Order.OrderItem.ItemPrice itemPrice = new CreateOrderRequest.FTDOrders.Order.OrderItem.ItemPrice();
        itemPrice.setItemTotal(new BigDecimal("114.90"));
        itemPrice.setItemRetailPrice(new BigDecimal("89.99"));
        itemPrice.setItemSalePrice(new BigDecimal("81.00"));
        itemPrice.setItemShippingServiceFeeTotal("16.99");
        itemPrice.setItemTaxTotal("7.92");
        itemPrice.setItemDiscountCode("12345");

        orderItem.setItemPrice(itemPrice);

        order.getOrderItem().add(orderItem);

        JAXBElement response = (JAXBElement) webServiceTemplate
                .marshalSendAndReceive("https://partner-qa02.ftdi.com/partners/FTDOrderService",
                        submitOrderFeedJAXBElement,
                        var1 -> addAuthHeader()
                );
    }

    private void addAuthHeader() {
        TransportContext context = TransportContextHolder.getTransportContext();
        HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();
        connection.getConnection().addRequestProperty("FTD_AUTH_USERNAME", "provide_test");
        connection.getConnection().addRequestProperty("FTD_AUTH_PASSWORD", "provide_test");
    }
}
