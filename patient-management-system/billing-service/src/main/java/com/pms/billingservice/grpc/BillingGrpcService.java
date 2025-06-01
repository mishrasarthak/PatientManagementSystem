package com.pms.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> responseObserver ) {
        log.info("Create billing account request received {}", billingRequest.toString());

        //Business logic - save to DB, perform calculations etc.
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345").setStatus("SUCCESS").build();

        responseObserver.onNext(response); // send response from our grpc service
        responseObserver.onCompleted(); // response is completed and close the cycle
    }
}
