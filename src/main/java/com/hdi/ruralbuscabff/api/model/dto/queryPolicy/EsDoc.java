package com.hdi.ruralbuscabff.api.model.dto.queryPolicy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EsDoc {

    @JsonProperty("AgentIdNo")
    private String agentIdNo;

    @JsonProperty("CommunicationType")
    private String communicationType;

    @JsonProperty("CustomerName")
    private String customerName;

    @JsonProperty("EffectiveDate")
    private String effectiveDate;

    @JsonProperty("ExpiryDate")
    private String expiryDate;

    @JsonProperty("FirstDataEntryDate")
    private String firstDataEntryDate;

    @JsonProperty("IdNo")
    private String idNo;

    @JsonProperty("InsuredIdNo")
    private String insuredIdNo;

    @JsonProperty("InsuredIdType")
    private String insuredIdType;

    @JsonProperty("LocAddress")
    private String locAddress;

    @JsonProperty("LocCity")
    private String locCity;

    @JsonProperty("LocPostCode")
    private String locPostCode;

    @JsonProperty("LocSeqNumber")
    private String locSeqNumber;

    @JsonProperty("LocState")
    private String locState;

    @JsonProperty("PHAgreementCode")
    private String pHAgreementCode;

    @JsonProperty("pHCode")
    private String pHCode;

    @JsonProperty("PHUnit")
    private String pHUnit;

    @JsonProperty("PolicyHolder")
    private String policyHolder;

    @JsonProperty("PolicyId")
    private Long policyId;

    @JsonProperty("PolicyStatus")
    private Integer policyStatus;

    @JsonProperty("PolicyType")
    private String policyType;

    @JsonProperty("ProductCode")
    private String productCode;

    @JsonProperty("ProductId")
    private Long productId;

    @JsonProperty("ProductName")
    private String productName;

    @JsonProperty("ProposalDate")
    private String proposalDate;

    @JsonProperty("ProposalNo")
    private String proposalNo;

    @JsonProperty("ProposalStatus")
    private Integer proposalStatus;

    @JsonProperty("WelcomeKit")
    private String welcomeKit;

    @JsonProperty("entity_id")
    private Long entity_id;

    @JsonProperty("entity_type")
    private String entity_type;

    @JsonProperty("id")
    private String id;

    @JsonProperty("index_time")
    private String index_time;

    @JsonProperty("index_timestamp")
    private Long index_timestamp;

    @JsonProperty("tenant_code")
    private String tenant_code;

}
