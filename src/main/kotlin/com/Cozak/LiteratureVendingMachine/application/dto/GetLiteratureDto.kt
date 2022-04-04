package com.Cozak.LiteratureVendingMachine.application.dto

import javax.validation.constraints.NotEmpty

class GetLiteratureDto(@field:NotEmpty val mood: String, @field:NotEmpty val textLength: String )