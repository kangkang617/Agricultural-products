package com.kangkang.controller;

import com.google.common.collect.Maps;
import com.kangkang.hyperledgerfabric.ProductDTO;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.springframework.web.bind.annotation.*;

import java.util.Map;




@RestController
@RequestMapping("/contract")
@Slf4j
@AllArgsConstructor
public class ProductContractController {

//   final Gateway gateway;

/*
   @GetMapping("/{key}")
   @ApiOperation(value = "从区块链中查询作物")
   public Map<String , Object> queryProductByKey(@PathVariable String key) throws ContractException {

       Map<String , Object> result = Maps.newConcurrentMap();
       Contract contract = getContract();
       byte[] cat = contract.evaluateTransaction("queryProduct", key);

       result.put("payload" , StringUtils.newStringUtf8(cat));
       result.put("status" , "ok");

       return result;
   }

    @PutMapping("/")
    @ApiOperation(value = "向区块链中添加作物")
    public Map<String , Object> createProduct(@RequestBody ProductDTO product) throws ContractException {

        Map<String , Object> result = Maps.newConcurrentMap();
        Contract contract = getContract();
        byte[] bytes = contract.evaluateTransaction("createProduct", product.getKey(),  product.getProductName(),product.getFarmName(),product.getCharge(),product.getProcess(),product.getRetail(),product.getTransport(),product.getTransportId());

        result.put("payload" , StringUtils.newStringUtf8(bytes));
        result.put("status" , "ok");

        return result;
    }



   private Contract getContract() {

       // 获取通道
       Network network = gateway.getNetwork("mychannel");

       // 获取合约
       return network.getContract("hyperledger-fabric-contract-java-demo");
   }*/
}
