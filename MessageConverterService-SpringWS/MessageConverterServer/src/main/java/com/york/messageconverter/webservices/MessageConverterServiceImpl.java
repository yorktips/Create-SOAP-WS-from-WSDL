package com.york.messageconverter.webservices;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.york.messageconverter.server.SoapMashallUnMashall;
import com.york.messageconverter.utils.SOAPUtils;


@WebService(endpointInterface = "com.york.messageconverter.webservices.MessageConverterService")
public class MessageConverterServiceImpl  implements MessageConverterService{
	
	private SOAPUtils util= new SOAPUtils();

	@Override
    public MessageParseResponse parse(MessageParseRequest arg0) throws java.rmi.RemoteException {
		String source=arg0.getSource();
		System.out.println("source=" + source);

		MessageParseResponse parseResponse=SoapMashallUnMashall.unMashallMessageParseResponse(util.file2String("parseResponse.xml"));

		return parseResponse;
		
//		MessageParseResponse response = new MessageParseResponse();
//		ConvertibleInterbankMessage[] parsedMessages= new ConvertibleInterbankMessage[1];
//		parsedMessages[0]= new ConvertibleInterbankMessage();
//		
//		ConvertibleInterbankMessage msg= new ConvertibleInterbankMessage();
//		
//		msg.setAckCustomerReferenceNumber("AckCustomerReferenceNumber");
//		
//		GregorianCalendar gregory = new GregorianCalendar();
//		XMLGregorianCalendar calendar=null;
//		gregory.setTime(new Date());
//		try{
//			calendar = DatatypeFactory.newInstance()
//			        .newXMLGregorianCalendar(
//			            gregory);
//			msg.setAckCustomerTimestamp(calendar);
//		}catch(Exception e) {
//			
//		}
//		
//		MasterRecord masterRecord = new MasterRecord();
//		masterRecord.setSystemType("systemType");
//		masterRecord.setTransactionReferenceNumber("transactionReferenceNumber");
//		masterRecord.setMessageIndex("messageIndex");
//		masterRecord.setMessageTotal("messageTotal");
//		masterRecord.setMessagePurpose("messagePurpose");
//		masterRecord.setCustomerReferenceNumber("customerReferenceNumber");
//		masterRecord.setMessageCreationDateTime(null );
//		masterRecord.setMethodOfIssue("methodOfIssue");
//		masterRecord.setMethodOfIssueDetails("methodOfIssueDetails");
//		masterRecord.setSettlementAccountNumber("settlementAccountNumber");
//		masterRecord.setBankChargesPayableBy("bankChargesPayableBy");
//		masterRecord.setBankChargesPayableByDetails("bankChargesPayableByDetails");
//		masterRecord.setChargesAccountNumber("chargesAccountNumber");
//		masterRecord.setConfirmationChargersPayableBy("confirmationChargersPayableBy");
//		masterRecord.setTransportMode("transportMode");
//		masterRecord.setTransportModeDetails("transportModeDetails");
//		masterRecord.setForwardContractReferenceNumber("forwardContractReferenceNumber");
//		masterRecord.setApplicantUndertaking("applicantUndertaking");
//		masterRecord.setSequence("sequence");
//		masterRecord.setSequenceOfTotal("sequenceOfTotal");
//		masterRecord.setFormOfDocumentaryCredit("formOfDocumentaryCredit");
//		masterRecord.setDocumentaryCreditNumber("documentaryCreditNumber");
//		masterRecord.setReferenceToPreAdvice("referenceToPreAdvice");
//		masterRecord.setDateOfIssue( calendar );
//		masterRecord.setApplicableRules("applicableRules");
//		masterRecord.setApplicableRulesDetails("applicableRulesDetails");
//		masterRecord.setExpiryDate( calendar );
//		masterRecord.setExpiryPlace("expiryPlace");
//		masterRecord.setAdvisingBankPartyIdentifier("advisingBankPartyIdentifier");
//		masterRecord.setAdvisingBankIdentifierCode("advisingBankIdentifierCode");
//		masterRecord.setAdvisingBankNameAddress("advisingBankNameAddress");
//		masterRecord.setApplicantBankPartyIdentifier("applicantBankPartyIdentifier");
//		masterRecord.setApplicantBankIdentifierCode("applicantBankIdentifierCode");
//		masterRecord.setApplicantBankNameAddress("applicantBankNameAddress");
//		masterRecord.setApplicantBankLocation("applicantBankLocation");
//		masterRecord.setApplicantNameAddress("applicantNameAddress");
//		masterRecord.setBeneficiaryAccountNumber("beneficiaryAccountNumber");
//		masterRecord.setBeneficiaryNameAddress("beneficiaryNameAddress");
//		masterRecord.setBeneficiaryContact("beneficiaryContact");
//		masterRecord.setLcCurrency("lcCurrency");
//		masterRecord.setLcAmount( new BigDecimal(0) );
//		masterRecord.setTolerancePlus( 0 );
//		masterRecord.setToleranceMinus( 0 );
//		masterRecord.setMaximumCreditAmount("maximumCreditAmount");
//		masterRecord.setAdditionalAmountsCovered("additionalAmountsCovered");
//		masterRecord.setAvailableWithIdentifierCode("availableWithIdentifierCode");
//		masterRecord.setAvailableWithCode("availableWithCode");
//		masterRecord.setAvailableWithNameAddress("availableWithNameAddress");
//		masterRecord.setAvailableByCode("availableByCode");
//		masterRecord.setDraftsAt("draftsAt");
//		masterRecord.setDraweePartyIdentifier("draweePartyIdentifier");
//		masterRecord.setDraweeIdentifierCode("draweeIdentifierCode");
//		masterRecord.setDraweeNameAddress("draweeNameAddress");
//		masterRecord.setDraweeCode("draweeCode");
//		masterRecord.setMixedDefPaymentDetails("mixedDefPaymentDetails");
//		masterRecord.setPartialShipments("partialShipments");
//		masterRecord.setTranshipment("transhipment");
//		masterRecord.setPlaceOfTakingInCharge("placeOfTakingInCharge");
//		masterRecord.setPortOfLoading("portOfLoading");
//		masterRecord.setPortOfDischarge("portOfDischarge");
//		masterRecord.setPlaceOfFinalDestination("placeOfFinalDestination");
//		masterRecord.setLatestDateOfShipment( calendar );
//		masterRecord.setShipmentPeriod("shipmentPeriod");
//		masterRecord.getDescriptionOfGoods().add("DescriptionOfGoods");
//		masterRecord.getDocumentsRequired().add("null");
//		masterRecord.getAdditionalConditions().add("null" );
//		masterRecord.setCharges("charges");
//		masterRecord.setPeriodForPresentation("periodForPresentation");
//		masterRecord.setConfirmationInstructions("confirmationInstructions");
//		masterRecord.setReimbursingBankIdentifierCode("reimbursingBankIdentifierCode");
//		masterRecord.setReimbursingBankPartyIdentifier("reimbursingBankPartyIdentifier");
//		masterRecord.setReimbursingBankNameAddress("reimbursingBankNameAddress");
//		masterRecord.setInstructions("instructions");
//		masterRecord.setAdviseThroughBankIdentifierCode("adviseThroughBankIdentifierCode");
//		masterRecord.setAdviseThroughBankPartyIdentifier("adviseThroughBankPartyIdentifier");
//		masterRecord.setAdviseThroughBankNameAddress("adviseThroughBankNameAddress");
//		masterRecord.setSenderToReceiverInfo("senderToReceiverInfo");
//		masterRecord.setIssuingBankIdentifierCode("issuingBankIdentifierCode");
//		masterRecord.setIssuingBankPartyIdentifier("issuingBankPartyIdentifier");
//		masterRecord.setIssuingBankNameAddress("issuingBankNameAddress");
//		masterRecord.setSenderContact("senderContact");
//		masterRecord.setIssuingBankReferenceNumber("issuingBankReferenceNumber");
//		masterRecord.setReceiversReference("receiversReference");
//		masterRecord.setDateOfAmendment( calendar );
//		masterRecord.setNumberOfAmendment("numberOfAmendment");
//		masterRecord.getNarrative().add("null" );
//		masterRecord.setAmendmentCurrency("amendmentCurrency");
//		masterRecord.setIncreaseAmount("increaseAmount");
//		masterRecord.setDecreaseAmount("decreaseAmount");
//		masterRecord.setAdvisingBankReferenceNumber("advisingBankReferenceNumber");
//		masterRecord.setConfirmationInfo("confirmationInfo");
//		masterRecord.setConfirmationIndicator("confirmationIndicator");
//		masterRecord.setKindOfGuarantee("kindOfGuarantee");
//		masterRecord.setGuaranteeType("guaranteeType");
//		masterRecord.setGuaranteeTypeDetails("guaranteeTypeDetails");
//		masterRecord.setFormOfGuarantee("formOfGuarantee");
//		masterRecord.setWordingCode("wordingCode");
//		masterRecord.setSpecialTerms("specialTerms");
//		masterRecord.setWordingLanguage("wordingLanguage");
//		masterRecord.setAltApplicantNameAddress("altApplicantNameAddress");
//		masterRecord.setIndicatorOfAlternativeBeneficialOwner("indicatorOfAlternativeBeneficialOwner");
//		masterRecord.setAmountType("amountType");
//		masterRecord.setValidityType("validityType");
//		masterRecord.setExpectedExpiryDate(calendar);
//		masterRecord.setValidUntil("validUntil");
//		masterRecord.setDeliveryTo("deliveryTo");
//		masterRecord.setDeliveryAddress("deliveryAddress");
//		masterRecord.setLiabilityDetails("liabilityDetails");
//		masterRecord.setReferenceCode("referenceCode");
//		masterRecord.setGuaranteeReference("guaranteeReference");
//		masterRecord.setReferenceDate1( calendar );
//		masterRecord.setReferenceDate2(calendar );
//		masterRecord.setContractCurrency("contractCurrency");
//		masterRecord.setContractAmount("contractAmount");
//		masterRecord.setGuaranteeValueInPercent("guaranteeValueInPercent");
//		masterRecord.setExtensionCode("extensionCode");
//		masterRecord.setExtensionDetails("extensionDetails");
//		masterRecord.setExtensionNotice("extensionNotice");
//		masterRecord.setMultipleDrawings("multipleDrawings");
//		masterRecord.setPartialDrawings("partialDrawings");
//		masterRecord.setDrawingRequirements("drawingRequirements");
//		masterRecord.setSecondaryCreditBeneficiary("secondaryCreditBeneficiary");
//		masterRecord.setSecondaryCreditBeneficiaryContact("secondaryCreditBeneficiaryContact");
//		masterRecord.setSecondaryCreditTypeCode("secondaryCreditTypeCode");
//		masterRecord.setSecondaryCreditTypeDetails("secondaryCreditTypeDetails");
//		masterRecord.setSecondaryCreditCurrency("secondaryCreditCurrency");
//		masterRecord.setSecondaryCreditAmount("secondaryCreditAmount");
//		masterRecord.setSecondaryCreditExpiryDate( calendar );
//		masterRecord.setCreditPurpose("creditPurpose");
//		masterRecord.getGuaranteeDetails().add("null" );
//		masterRecord.setFurtherIdentification("furtherIdentification");
//		masterRecord.setChargesDate( calendar);
//		masterRecord.setChargesCurrency("chargesCurrency");
//		masterRecord.setChargesAmount("chargesAmount");
//		masterRecord.setAmountSpecification("amountSpecification");
//		masterRecord.setAdditionalRemarks("additionalRemarks");
//		masterRecord.setAdvisingBankCharges("advisingBankCharges");
//		masterRecord.setCustomerNoOrAccountNo("customerNoOrAccountNo");
//		masterRecord.setFirstAdvisingBankIdentifierCode("firstAdvisingBankIdentifierCode");
//		masterRecord.setFirstAdvisingBankNameAddress("firstAdvisingBankNameAddress");
//		masterRecord.setFirstAdvisingBankReference("firstAdvisingBankReference");
//		masterRecord.setTransferringBankIdentifierCode("transferringBankIdentifierCode");
//		masterRecord.setTransferringBankNameAddress("transferringBankNameAddress");
//		masterRecord.setTransferringBankReference("transferringBankReference");
//		masterRecord.setAdvisingDate( calendar );
//		masterRecord.setAdvisingBankComments("advisingBankComments");
//		masterRecord.setFileIdentification("fileIdentification");
//		masterRecord.setPreadviceReference("preadviceReference");
//		masterRecord.setNonBankIssuer("nonBankIssuer");
//		masterRecord.setThirdPartyReference("thirdPartyReference");
//		masterRecord.setMessageReason("messageReason");
//		masterRecord.setRecourseIndicator("recourseIndicator");
//		masterRecord.setAmountClaimedCurrency("amountClaimedCurrency");
//		masterRecord.setAmountClaimed( new BigDecimal(0) );
//		masterRecord.setCounterpartyChargesCurrency("counterpartyChargesCurrency");
//		masterRecord.setCounterpartyCharges( new BigDecimal(0) );
//		masterRecord.setTotalAmountClaimedCurrency("totalAmountClaimedCurrency");
//		masterRecord.setTotalAmountClaimed( new BigDecimal(0) );
//		masterRecord.setOwnChargesAmountCurrency("ownChargesAmountCurrency");
//		masterRecord.setOwnChargesAmount( new BigDecimal(0) );
//		masterRecord.setFeeType("feeType");
//		masterRecord.setFeeCurrency("feeCurrency");
//		masterRecord.setFeeAmount( new BigDecimal(0) );
//		masterRecord.setDebitAmount( new BigDecimal(0) );
//		masterRecord.setRefundAmount( new BigDecimal(0) );
//		masterRecord.setCalculationFrom( calendar );
//		masterRecord.setCalculationTo( calendar );
//		masterRecord.setCommissionRate( new BigDecimal(0) );
//		masterRecord.setLatestDateForReply( calendar );
//		masterRecord.setDebitAmountCurrency("debitAmountCurrency");
//		masterRecord.setRefundAmountCurrency("refundAmountCurrency");
//		masterRecord.setExtensionExpiryDate(calendar );
//		masterRecord.setMethodOfTransmission("methodOfTransmission");
//		masterRecord.setMethodOfTransmissionDetails("methodOfTransmissionDetails");
//		masterRecord.setMethodOfDelivery("methodOfDelivery");
//		masterRecord.setMethodOfDeliveryDetails("methodOfDeliveryDetails");
//		masterRecord.setOwnChargesDetails("ownChargesDetails");
//		masterRecord.setConfirmingBankReferenceNumber("confirmingBankReferenceNumber");
//		masterRecord.setConfirmingBankIdentifierCode("confirmingBankIdentifierCode");
//		masterRecord.setAdditionalAmountsCoveredCurrency("additionalAmountsCoveredCurrency");
//		masterRecord.setReceivedOnDate(calendar );
//		masterRecord.setIssuingBankContact("issuingBankContact");
//		masterRecord.setAdvisingBankContact("advisingBankContact");
//		masterRecord.setDrawCurrency("drawCurrency");
//		masterRecord.setDrawAmount( new BigDecimal(0) );
//		masterRecord.setDrawDate( calendar );
//		masterRecord.setDiscrepancies("discrepancies");
//		masterRecord.setNotifiedDiscrepancies("notifiedDiscrepancies");
//		masterRecord.setLocalDiscrepencies("localDiscrepencies");
//		masterRecord.setDisposalOfDocuments("disposalOfDocuments");
//		masterRecord.setDateOfAdviceOfDiscrepancy( calendar );
//		masterRecord.setReceiversCorrespondentPartyIdentifier("receiversCorrespondentPartyIdentifier");
//		masterRecord.setReceiversCorrespondentIdentifierCode("receiversCorrespondentIdentifierCode");
//		masterRecord.setReceiversCorrespondentNameAddress("receiversCorrespondentNameAddress");
//		masterRecord.setSecondBeneficiaryAdvisingBankPartyIdentifier("secondBeneficiaryAdvisingBankPartyIdentifier");
//		masterRecord.setSecondBeneficiaryAdvisingBankIdentifierCode("secondBeneficiaryAdvisingBankIdentifierCode");
//		masterRecord.setSecondBeneficiaryAdvisingBankNameAddress("secondBeneficiaryAdvisingBankNameAddress");
//		masterRecord.setSecondBeneficiaryNameAddress("secondBeneficiaryNameAddress");
//		masterRecord.setSecondBeneficiaryReferenceNumber("secondBeneficiaryReferenceNumber");
//		masterRecord.setSecondBeneficiaryCustomerContact("secondBeneficiaryCustomerContact");
//		masterRecord.setFirstBeneficiaryNameAddress("firstBeneficiaryNameAddress");
//		masterRecord.setFirstBeneficiaryCustomerContact("firstBeneficiaryCustomerContact");
//		masterRecord.setDateOfPresentation( calendar );
//		masterRecord.setDeferredPaymentDate( calendar );
//		masterRecord.setNotificationStatus("notificationStatus");
//		masterRecord.setDetailsOfCommissionAndCharges("detailsOfCommissionAndCharges");
//		masterRecord.setExternalExpensesCurrency("externalExpensesCurrency");
//		masterRecord.setExternalExpensesAmount( new BigDecimal(0) );
//		masterRecord.setAgentsCommissionCurrency("agentsCommissionCurrency");
//		masterRecord.setAgentsCommissionAmount( new BigDecimal(0) );
//		masterRecord.setAssignedTransferredCurrency("assignedTransferredCurrency");
//		masterRecord.setAssignedTransferredAmount( new BigDecimal(0) );
//		masterRecord.setRedirectedCurrency("redirectedCurrency");
//		masterRecord.setRedirectedAmount( new BigDecimal(0) );
//		masterRecord.setSettlementAccountTotalCurrency("settlementAccountTotalCurrency");
//		masterRecord.setSettlementAccountTotalAmount( new BigDecimal(0) );
//		masterRecord.setValueDate( calendar );
//		masterRecord.setCustomerIdentifier("customerIdentifier");
//		masterRecord.setCommissionCurrency("commissionCurrency");
//		masterRecord.setCommissionAmount( new BigDecimal(0) );
//		masterRecord.setDateOfMaturity( calendar );
//		masterRecord.setSettlementAmount( new BigDecimal(0) );
//		masterRecord.setSettlementAmountCurrency("settlementAmountCurrency");
//		masterRecord.setExchangeRate( new BigDecimal(0) );
//		masterRecord.setCountervalueAmount( new BigDecimal(0) );
//		masterRecord.setCountervalueAmountCurrency("countervalueAmountCurrency");
//		masterRecord.setAdvisingBankAdditionalReferenceNumber("advisingBankAdditionalReferenceNumber");
//		masterRecord.setDocumentsSentVia("documentsSentVia");
//		masterRecord.setCourierName("courierName");
//		masterRecord.setCourierReferenceNumber("courierReferenceNumber");
//		masterRecord.setPaymentDate( calendar );
//		masterRecord.setSightCurrency("sightCurrency");
//		masterRecord.setSightAmount( new BigDecimal(0) );
//		masterRecord.setDeferredPaymentCurrency("deferredPaymentCurrency");
//		masterRecord.setDeferredPaymentAmount( new BigDecimal(0) );
//		masterRecord.setDiscrepancyRemark( 0 );
//		masterRecord.setDiscrepanciesAgreedUponWith("discrepanciesAgreedUponWith");
//		masterRecord.setLiabilityRemark("liabilityRemark");
//		masterRecord.setCounterValueCurrency("counterValueCurrency");
//		masterRecord.setCounterValueAmount( new BigDecimal(0) );
//		masterRecord.setReservationIdentifier( 0 );
//		masterRecord.setIncreaseAmountCurrency("increaseAmountCurrency");
//		masterRecord.setDecreaseAmountCurrency("decreaseAmountCurrency");
//		masterRecord.setTotalUtilizationAmountCurrency("totalUtilizationAmountCurrency");
//		masterRecord.setTotalUtilizationAmount( new BigDecimal(0) );
//		masterRecord.setSendersCorrespondentPartyIdentifier("sendersCorrespondentPartyIdentifier");
//		masterRecord.setSendersCorrespondentIdentifierCode("sendersCorrespondentIdentifierCode");
//		masterRecord.setSendersCorrespondentNameAddress("sendersCorrespondentNameAddress");
//		masterRecord.setReferenceNo("referenceNo");
//		masterRecord.setNetAmountCurrency("netAmountCurrency");
//		masterRecord.setNetAmount( new BigDecimal(0) );
//		masterRecord.setChargesClaimed("chargesClaimed");
//		masterRecord.setChargesAdded("chargesAdded");
//		masterRecord.setAdditionalAmountsCurrency("additionalAmountsCurrency");
//		masterRecord.setAdditionalAmounts( new BigDecimal(0) );
//		masterRecord.setAmountBeforeCharges( new BigDecimal(0) );
//		masterRecord.setAmountBeforeChargesCurrency("amountBeforeChargesCurrency");
//		masterRecord.setPaymentTerms("paymentTerms");
//		masterRecord.setAdviseThroughBankLocation("adviseThroughBankLocation");
//		masterRecord.setSenderInfo("senderInfo");
//		masterRecord.setReceiverInfo("receiverInfo");		
//		
//		msg.setMasterRecord(masterRecord);
//		msg.setAckErrorCode("AckErrorCode");
//		msg.setMasterRecord(masterRecord);
//		msg.setAckFlag(true);
//		msg.setTransactionReferenceId("TransactionReferenceId");
//		msg.setSenderId("SenderId");
//		msg.setMessageType("MessageType");
//		msg.setMessageTotal(1);
//		msg.setMessageText("MessageText");
//		msg.setMessageIndex(1);
//		
//		
//		response.getParsedMessages().add(msg);
//		
//		response.setServiceStatusDescription("ServiceStatusDescription");
//		response.setServiceStatus(ServiceStatus.SUCCESS);
//
//		return response;

	}

	
	@Override
	public BundleValidateResponse validate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException {
		System.out.println("arg0.length=" + arg0.length);

		SoapMashallUnMashall unmashall= new SoapMashallUnMashall();

		BundleValidateResponse response=SoapMashallUnMashall.unMashallBundleValidateResponse(util.file2String("validateResponse.xml"));

		return response;
	}
	
	
	@Override
	public MessageGenerateResponse generate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException {
		System.out.println("arg0.length=" + arg0.length);

		SoapMashallUnMashall unmashall= new SoapMashallUnMashall();

		MessageGenerateResponse response=SoapMashallUnMashall.unMashallMessageGenerateResponse(util.file2String("generateResponse.xml"));

		return response;
	}
	
}

