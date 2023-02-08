package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return a reference asset")
    request {
        method POST()
        url(value(consumer(regex('/references/organizations/[a-zA-Z0-9]+/assets/[a-zA-Z0-9]+'))))
        headers {
            contentType(applicationJson())
        }
        body '''
		        {
			          "requestedDate": "2021-05-15",
			          "dataRequestedDate": "2021-05-16",
			          "allAssets" : true,
			          "requestedPropertyCodes": ["ADDRESS", "PHOTO_URL"],
			          "authorizedAssetCodes": ["59L"]
		        }
		    '''

    }
    response {
        body'''
           {
               "organizationCode": "",
               "code": "",
               "name": "",
               "type": {
                 "type": "",
                 "code": "",
                 "names": [ ]
               },
               "parent": null,
               "effectiveDate": null,
               "expirationDate": null,
               "hierarchy": null,
               "children": null,
               "contractCodes": null,
               "contracts": null,
               "certificateCodes": null,
               "certificates": null,
               "documentCodes": null,
               "documents": null,
               "data": null,
               "stonalIdentifier": null,
               "parentStonalIdentifier": null,
               "externalIdentifiers": null
           }
        '''
        status 200
    }
}
