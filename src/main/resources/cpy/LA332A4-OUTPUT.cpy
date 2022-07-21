       01  LA332A4.
           03 TX-LIFE-REQ OCCURS 100 TIMES.
              05 TRANS-REF-GUID PIC X(036) VALUE SPACES.
              05 TRANS-TYPE.
                 07 TRANS-TYPE-TC PIC X(010) VALUE SPACES.
                 07 TRANS-TYPE-TC-DESC PIC X(030) VALUE SPACES.
              05 DATA-TRANS-SUB-TYPE.
                 07 TRANS-SUB-TYPE-TC PIC X(010) VALUE SPACES.
                 07 TRANS-SUB-TYPE-TC-DESC PIC X(030) VALUE SPACES.
              05 TRANS-EXE-DATE PIC X(010) VALUE SPACES.
              05 TRANS-EXE-TIME PIC X(010) VALUE SPACES.
              05 CHANGE-SUB-TYPE.
                 07 TRAN-CONTENT-CODE.
                    09 TRAN-CONTENT-CODE-TC PIC X(001) VALUE SPACES.
                    09 TRAN-CNT-CODE-TC-DEC PIC X(029) VALUE SPACES.
              05 TRANS-RESULT.
                 07 RESULT-CODE.
                    09 RESULT-CODE-TC  PIC X(001) VALUE SPACES.
                    09 RESULT-CODE-TC-DESC PIC X(020) VALUE SPACES.
                    09 RESULT-INFO-DESC PIC X(500) VALUE SPACES.
              05 OLIFE.
                 07 FORM-INSTANCE.
                    09 FORM-INSTANCE-ID PIC X(025) VALUE SPACES.
                    09 ASSOCIATED-RESP-DATA. 
                       11 ACTUAL-OBJECT-TYPE.
                          13 TC PIC X(002) VALUE SPACES.
                          13 TC-DESC PIC X(010) VALUE SPACES.
                 07 OLIFE-EXTN.
                    09 MESSAGE-SOURCE.
                       11 MESSAGE-SOURCE-TC PIC X(001) VALUE SPACES.
                       11 TC-DESC PIC X(020) VALUE SPACES.
                    09 USER-LOGIN-ID PIC X(020) VALUE SPACES.
              05 HOLDING.
                 07 HOLDING-ID  PIC X(025) VALUE SPACES.
                 07 POLICY.
                    09 POLC-NBR PIC X(013) VALUE SPACES.
                    09 CARRIER-CODE PIC X(022) VALUE SPACES.
                    09 EFF-DATE PIC X(010) VALUE SPACES.
              05 PARTY.
                 07 PARTY-ID PIC X(025) VALUE SPACES.
                 07 ID-REF-NO PIC X(013) VALUE SPACES.
                 07 ID-REF-TYPE.
                    09 ID-REF-TYPE-TC PIC X(010) VALUE SPACES.
                    09 ID-REF-TYPE-TC-DESC PIC X(028) VALUE SPACES.
                 07 PERSON.
                    09 FIRST-NAME PIC X(060) VALUE SPACES.
                    09 MIDDLE-NAME PIC X(060) VALUE SPACES.
                    09 LAST-NAME PIC X(060) VALUE SPACES.
                    09 NICK-NAME PIC X(060) VALUE SPACES.
                    09 INITIALS PIC X(003) VALUE SPACES.
                    09 TITLE1 PIC X(030) VALUE SPACES.
                    09 GENDER.
                       11 GENDER-TC PIC X(001) VALUE SPACES.
                       11 GENDER-TC-DESC PIC X(009) VALUE SPACES.
                    09 BIRTH-DATE PIC X(010) VALUE SPACES.
                    09 BIRTH-COUNTRY.
                       11 BIRTH-COUNTRY-TC PIC X(010) VALUE SPACES.
                       11 BIRTH-COUNTRY-TC-DESC PIC X(030) VALUE SPACES.
                 07 ADDRESS1.
                    09 ADDRESS-ID PIC X(025) VALUE SPACES.
                    09 LINE1 PIC X(030) VALUE SPACES.
                    09 LINE2 PIC X(030) VALUE SPACES.
                    09 LINE3 PIC X(030) VALUE SPACES.
                    09 LINE4 PIC X(030) VALUE SPACES.
                    09 ZIP PIC X(005) VALUE SPACES.
                 07 RISK.
                    09 OLIFE-EXT.
                       11 VENDOR-CODE PIC X(020) VALUE SPACES.
                       11 IMPAIRMENT OCCURS 9 TIMES.
                          13 IMPAIRMENTFIELD PIC X(124) VALUE SPACES.
                       11 R-IMPAIRMENT.
                          13 IMPAIRMENT-CODE PIC X(010) VALUE SPACES.
                          13 READINGS.
                             15 READING PIC X(020) VALUE SPACES.
                             15 TIME-PERIOD PIC X(014) VALUE SPACES.
                          13 IMPAIRMENT-SYMBOLS PIC X(005) VALUE SPACES.
                          13 IMPAIRMENT-SPL OCCURS 9 TIMES.
                             15 IMP-SPL-INV PIC X(015) VALUE SPACES.
                          13 DOCTOR-NAME PIC X(015) VALUE SPACES.
              05 RELATION.
                 07 RELATION-ID PIC X(025) VALUE SPACES.
                 07 ORIGINATING-OBJECT-ID PIC X(025) VALUE SPACES.
                 07 RELATED-OBJECT-ID PIC X(025) VALUE SPACES.
                 07 RELATED-OBJECT-TYPE.
                    09 TYPE-TC PIC X(002) VALUE SPACES.
                    09 TYPE-TC-DESC PIC X(008) VALUE SPACES.
                 07 RELATION-ROLE-CODE.
                    09 CODE-TC PIC X(002) VALUE SPACES.
                    09 CODE-TC-DESC PIC X(008) VALUE SPACES.