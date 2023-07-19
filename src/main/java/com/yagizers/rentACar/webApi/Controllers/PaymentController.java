package com.yagizers.rentACar.webApi.Controllers;

import com.yagizers.rentACar.business.Abstracts.PaymentService;
import com.yagizers.rentACar.business.dtos.requests.create.CreatePaymentRequest;
import com.yagizers.rentACar.business.dtos.requests.update.UpdatePaymentRequest;
import com.yagizers.rentACar.business.dtos.responses.create.CreatePaymentResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetAllPaymentsResponse;
import com.yagizers.rentACar.business.dtos.responses.get.GetPaymentResponse;
import com.yagizers.rentACar.business.dtos.responses.update.UpdatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @GetMapping
    public List<GetAllPaymentsResponse> getAllPayments(){
        return this.paymentService.getAll();
    }
    @RequestMapping(value = "/byId/{id}",method = RequestMethod.GET)
    public GetPaymentResponse getPaymentById(@PathVariable int id){
        return this.paymentService.getPaymentById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePaymentResponse addPayment(CreatePaymentRequest request){
        return paymentService.addPayment(request);
    }
    @RequestMapping(value = "/updatePayment/{id}",method = RequestMethod.PUT)
    public UpdatePaymentResponse updatePayment(@PathVariable int id, @RequestBody UpdatePaymentRequest request){
        return  paymentService.updatePayment(id,request);
    }

    @RequestMapping(value = "deletePayment/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deletePayment(@PathVariable  int id){
        this.paymentService.deletePayment(id);
    }
}
