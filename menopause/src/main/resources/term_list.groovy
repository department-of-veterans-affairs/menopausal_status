import gov.va.vinci.menopause.types.*;
name = "RegexAnnotator"

configuration {
    /* All configuration for this annotator. */
    defaults {
        /* Global for all configrations below if a property specified here is not overridden in a section below. */
        case_sensitive = false
        concept_feature_name = "concept"
        matchedPatternFeatureName = "pattern"
        outputType = "gov.va.vinci.menopause.types.Term"
    }

//    "menstruation_type" {
//        expressions = [
//                'hypermenorrhea'
//                ,'oligomenorrhea'
//                ,'dysmennorhea'
//                ,'menometorrhagia'
//                ,'polymenorrhea'
//                ,'menometrorrhagia'
//                ,'menorrhagia'
//        ]
//        outputType = "gov.va.vinci.menopause.types.MenstrualType"
//    }

    "perimenopause" {
        expressions = [
                'peri(\\s|-)*men(o|a)paus(e|al)\\b',
                'menopaus(e|al)\\stransition'
        ]
        outputType = "gov.va.vinci.menopause.types.Perimenopause"
    }


    "postmenopausal" {
        expressions = [
                 '\\b(past|post)(\\s|-)*men(o|a)paus(e|al)\\b'
                //,'postmen(o|a)pausal\\sbleeding' //important but not a date of menopause diagnosis
        ]
        outputType = "gov.va.vinci.menopause.types.Postmenopause"
    }

    "menopause" {
        expressions = [
                '\\bmen(o|a)paus(e|al)\\b'
        ]
        outputType = "gov.va.vinci.menopause.types.Menopause"
    }

    "natural_menopause" {
        expressions = [
                'WITH\\sGYN\\sMENOPAUSE'
                ,'SYMPTOMATIC\\sMENOPAUSAL\\sOR\\sFEMALE\\sCLIMACTERIC'
                ,'premature\\sovarian\\sfailure'
                ,'premature\\smenopause'
                ,'early\\smenopause'
                ,'primary\\sovarian\\s(insufficiency|failure)'
                ,'\\bpoi\\b'
                ,'\\bpof\\b'
                ,'genitourinary\\ssyndrome\\sof\\smenopause'
                ,'\\bgsm\\b'
        ]
        outputType = "gov.va.vinci.menopause.types.NaturalMenopause"
    }

    "surgical_menopause" {
        expressions = [
                'MENOPAUSAL\\s\\(SURGICAL\\)'
                ,'surgical\\s(post)?men(o|a)pause'
                ,'artificial\\s(post)?men(o|a)pause'
                ,'\\bhyst(erectomy)?\\b'
                ,'\\btah\\b' //total abdominal hysterectomy
                ,'\\blavh\\b' //laporoscopically assisted vaginal hysterectomy
                ,'\\tah-?bso\\b' //total abdominal hysterectomy and bilateral salpingo-oophorectomy
                ,'\\bbso\\b' //bilateral salpingo oophorectomy
                ,'\\b(bil|bilateral)?\\s*(salpingo)?-?\\s*ooph(orectom(y|ies))?\\b'
                ,'\\b(bil|bilateral)?\\s*ovariectom(y|ies)\\b'
                ,'\\bhystrectomy\\b'
                ,'\\bhysterctomy\\b'
                ,'\\bhys\\b'
                ,'\\bhyster\\b'
        ]
        outputType = "gov.va.vinci.menopause.types.SurgicalMenopause"
    }

//    "menopause_symptoms" {
//        //taken from mayo list of symptoms
//        expressions = [
//                'hot flash'
//                ,'irregular (period|menstruation)'
//                ,'vaginal dryness'
//                ,'chills'
//                ,'night sweat'
//                ,'sleep problems'
//                ,'mood changes'
//                ,'weight gain'
//                ,'thinning hair'
//                ,'hair thinning'
//                ,'dry skin'
//                ,'loss of breast fullness'
//        ]
//        outputType = "gov.va.vinci.menopause.types.Symptom"
//    }


    "menopause_treatments" {
        expressions = [
                'hormone\\sreplacement\\stherapy'
                ,'\\bhrt\\b'
        ]
        outputType = "gov.va.vinci.menopause.types.Treatment"
    }


    "last_menstrual_date" {
        expressions = [
                '\\bLMP',
                'last\\smenstrual\\speriod',
                'last\\smenses',
                'menstruation',
                'last\\smenstruation'
        ]
        outputType = "gov.va.vinci.menopause.types.LastMenstrualPeriod"
    }

    "date" {
        expressions = [
                '\\b\\d{4}(\'?s)?'
                ,'\\b\\d{1,2}(\\/|-)\\d{4}'
                ,'\\b\\d+\\+?\\s(day|week|month|year)s?\\sago'
                ,'(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)\\s*\\d{4}'
                ,'(january|february|march|april|may|june|july|august|september|october|november|december)\\s*\\d{4}'
                // -- extra date format for testing parer
                ,'\\b\\d{1,2}(\\/|-)\\d{1,2}(\\/|-)(\\d{2}|\\d{4})'
                ,'(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)\\s*\\d{1,2}\\,\\s*\\d{4}'
                ,'(january|february|march|april|may|june|july|august|september|october|november|december)\\s*\\d{1,2}\\,\\s*\\d{4}'
        ]
        outputType = "gov.va.vinci.menopause.types.Date"
    }

//    "exclusion_terms" {
//        expressions = [
//                'pregnant'
//                ,'pregnancy'
//        ]
//        outputType = "gov.va.vinci.menopause.types.Exclude"
//    }

    "birth_control_section" {
        expressions = [
                '\\bbc\\b'
                ,'(oral)?\\s*birth\\s*control(\\s*pills?)?'
                ,'(oral)?\\s*contraceptives?'
                ,'\\bocp\\b'
                ,'\\biud\\b'
        ]
        outputType = "gov.va.vinci.menopause.types.BirthControlSection"
    }

    "birth_control" {
        expressions = [
                '\\bIU(D|C|S)\\b'
                ,'copper\\s*IUD\\b'
                ,'\\bskyla\\b'
                ,'\\bliletta\\b'
                ,'\\bnexplanon\\b'
                ,'\\bbirth\\s*control\\b'
                ,'\\bcontraception\\b'
                ,'\\bkyleena\\b'
                ,'\\bmirena\\b' //model indicate we may not want breaks on this one
                ,'iud(:|/|-)?(mirena|paragard|nexplanon)'
                ,'mirena(-|/)?(iud|skyla|kyleena)'
                ,'depo(-|\\s*)?provera'
                ,'\\bdepot?\\b'
                ,'\\nprovera\\b' //hormone, used to treat irregular periods and menopause; looking for specific LMP patterns, so it is fine
                ,'paragu?ard(/copper)?'
                ,'\\bparagauard\\b'
                ,'\\bimplanon\\b'
                ,'\\bNuv(a|o)(-|\\s*)?Ring?'
                //patches
                ,"\\bxulane\\b"
                ,'\\btwirla\\b'
                ,'\\bortho(-|\\s*)?evra\\b'
                //,'\\bpatch' //may be too general
                ,'\\bbirth\\s*control\\s*patch\\b'
                //pill brand names from internet
                ,'\\bApri\\b'
                ,'\\bAlesse\\b'
                ,'\\bAranelle\\b'
                ,'\\bAviane\\b'
                ,'\\bBeyaz\\b'
                ,'\\bDesogen\\b'
                ,'\\bEstrostep(\\s*Fe)?\\b'
                ,'\\bGianvi\\b'
                ,'\\bKariva\\b'
                ,'\\bLessina\\b'
                ,'\\bLevlite\\b'
                ,'\\bLevora\\b'
                ,'\\bLoestrin\\b'
                ,'\\bLybrel\\b'
                ,'\\blutera\\b'
                ,'\\bLo\\s*Ovral\\b'
                ,'\\bNordette\\b'
                ,'\\bOcella\\b'
                ,'\\bLow(-|\\s*)?Ogestrel\\b'
                ,'\\bOrtho(-|\\s*)?Novum\\b'
                ,'\\bPrevifem\\b'
                ,'\\bReclipsen\\b'
                ,'\\bSafyral\\b'
                ,'\\bVelivet\\b'
                ,'\\bYasmin\\b'
                ,'\\bYaz\\b'
                ,'\\bAzurette\\b'
                ,'\\bMircette\\b'
                ,'\\bCaziant\\b'
                ,'\\bEnpresse\\b'
                ,'\\bOrtho(-|\\s*)?Tri(-|\\s*)?Cyclen\\b'
                ,'\\bTriNessa\\b'
                ,'\\bVelivet\\b'
                ,'\\bNatazia\\b'
                ,'\\bSeasonale\\b'
                ,'\\bSeasonique\\b'
                ,'\\bLybrel\\b'
                ,'\\bApri\\b'
                ,'\\bAviane\\b'
                ,'\\bLevora\\b'
                ,'\\bLoestrin\\b'
                ,'\\bCamila\\b'
                ,'\\bErrin\\b'
                ,'\\bHeather\\b'
                ,'\\bJencycla\\b'
                ,'\\bJolivette\\b'
                ,'\\bNor(-|\\s*)?QD\\b'
                ,'\\bNora(-|\\s*)?BE\\b'
                ,'\\bOrthoa(-|\\s*)?Micronor\\b'
                ,'\\bAygestin\\b'
                ,'\\bnorethindrone\\b'
                ,'\\bestradiol\\b'
                ,'\\bethinyl\\s*estradiol\\b'
                ,'\\bAzurette\\b'
                ,'\\bCyclessa\\b'
                ,'\\bDesogen\\b'
                ,'\\bIsibloom\\b'
                ,'\\bKariva\\b'
                ,'\\bMircette\\b'
                ,'\\bReclipsen\\b'
                ,'\\bGianvi\\b'
                ,'\\bLoryna\\b'
                ,'\\bNikki\\b'
                ,'\\bOcella\\b'
                ,'\\bSyeda\\b'
                ,'\\bVestura\\b'
                ,'\\bZarah\\b'
                ,'\\bBeyaz\\b'
                ,'\\bSafyral\\b'
                ,'\\bRajani\\b'
                ,'\\bTydemy\\b'
                ,'\\bDemulen\\b'
                ,'\\bKelnor\\b'
                ,'\\bZovia\\b'
                ,'\\bAmethyst\\b'
                ,'\\bAviane\\b'
                ,'\\bFalmina\\b'
                ,'\\bLevlen\\b'
                ,'\\bOrsythia\\b'
                ,'\\bVienva\\b'
                ,'\\bCryselle\\b'
                ,'\\bOgestrel\\b'
                ,'\\bEstarylla\\b'
                ,'\\bFemynor\\b'
                ,'\\bMono(-|\\s*)?Linyah\\b'
                ,'\\bMononessa\\b'
                ,'\\bPrevifem\\b'
                ,'\\bSprintec\\b'
                ,'\\bTri(-|\\s*)?Lo(-|\\s*)?Marzia\\b'
                ,'\\bTriNessa'
                ,'\\bBC\\b'
                ,'(oral)?\\s*birth\\s*control(\\s*pills?)?'
                ,'(oral)?\\s*contraceptives?'
                ,'\\bocp\\b'
        ]
        outputType = "gov.va.vinci.menopause.types.BirthControl"
    }


}
