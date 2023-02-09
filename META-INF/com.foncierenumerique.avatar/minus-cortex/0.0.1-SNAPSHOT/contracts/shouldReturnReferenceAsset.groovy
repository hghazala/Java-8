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
        headers {
            contentType(applicationJson())
        }
        body'''
        {
           "organizationCode": "GOLDENCOUNTRY",
           "code": "59L",
           "name": "LE VENDÔME",
           "type": {
               "type": "ASSET",
               "code": "BUILDING",
               "names": [
                   {
                       "singular": "immeuble",
                       "plural": "immeubles"
                   }
               ]
           },
           "parent": "",
           "effectiveDate": "2003-02-03",
           "expirationDate": "3000-01-01",
           "hierarchy": [
               "59L"
           ],
           "childrenCodes": [
               "59L3",
               "59L2",
               "59L1"
           ],
           "children": null,
           "contractCodes": [
               "B59L1",
               "B59L2"
           ],
           "contracts": null,
           "certificateCodes": null,
           "certificates": null,
           "documentCodes": null,
           "documents": null,
           "data": {
               "data": {
                   "ADDRESS": [
                       {
                           "property": {
                               "code": "ADDRESS",
                               "name": "Adresse",
                               "type": "TEXT",
                               "temporality": "INSTANT",
                               "holderType": "ASSET",
                               "holderCategories": [
                                   "BUILDING",
                                   "PARKING"
                               ]
                           },
                           "holderCode": "59L",
                           "value": "2, Impasse Augustin Fresnel, 44800 Saint Herblain",
                           "startDate": "1000-01-01",
                           "endDate": "3000-01-01",
                           "source": "Premiance - données sur les immeubles"
                       }
                   ],
                   "PHOTO": [
                       {
                           "property": {
                               "code": "PHOTO",
                               "name": "Photos",
                               "type": "TEXT",
                               "temporality": "INSTANT",
                               "holderType": "ASSET",
                               "holderCategories": [
                                   "BUILDING",
                                   "BUILDING_GROUP"
                               ]
                           },
                           "holderCode": "59L",
                           "value": "/ouvrir-document-64aaf259b259ae76da67f16211589513-0409cb9e5b8945e44a535fb51c46f016-a87cf265c9d4c2c5091b304364e26307.jpg",
                           "startDate": "1000-01-01",
                           "endDate": "3000-01-01",
                           "source": "Keep"
                       }
                   ]
               }
           }
        }
        '''
        status 200
    }
}
