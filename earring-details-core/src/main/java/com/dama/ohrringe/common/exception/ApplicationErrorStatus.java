package com.dama.ohrringe.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationErrorStatus {

    GENERIC_ERROR("Unexpected exception"),
    JAR_NOT_FOUND("LF-2", "Artifact %s cannot be found within supported JarLoaders"),
    NO_SUCH_BUNDLE("LF-3", "Bundle with id = %s cannot be found. Please, make sure you are trying to access existing Bundle"),
    FAILED_SWITCH_BUNDLE_STATE("LF-4", "Failed to switch bundle state to %s"),
    VALIDATION_FAILED("LF-5", "Validation of the request has failed"),
    BUNDLE_GENERATION_ERROR("LF-6", "Failed to generate bundle for campaign %s with name %s in %s folder"),
    BUNDLE_PUBLISHING_ERROR("LF-7", "Failed to publish bundle"),
    FAILED_CREATE_ENTITY("LF-8", "Failed to created a new %s entity due to data integrity violation: %s"),
    FAILED_UPDATE_ENTITY("LF-9", "Failed to update the %s entity due to data integrity violation: %s"),
    FAILED_DELETE_ENTITY("LF-11", "Failed to delete the %s entity due to data integrity violation: %s"),
    ENTITY_NOT_FOUND("LF-10", "%s with id %s not found in database"),
    ENTITY_ALREADY_EXIST("LF-11", "%s with external id %s has already existed in database"),
    NO_SUCH_PROGRAM("LF-8", "Could not find program with id = %s"),
    FAILED_TO_GENERATE_RULES("LF-12", "Failed to generate rules due to failed rules verification. Please, make sure that rules are written correctly"),
    FAILED_TO_UPDATE_BUNDLE("LF-999", "Failed to update %s bundle"),
    DEPLOYMENT_COMMAND_OPERATION_FAILED("LF-1111", "Failed to execute deployment operation that changes unit's state from %s to %s for unit %s"),
    RULE_EXECUTOR_REGISTRATION_ERROR("LF-13", "Failed to register rule executor [url=%s] by bundle manager [url=%s]"),
    REST_CLIENT_EXCEPTION("LF-345", "The request to %s [url = %s] has failed, status code: %s"),
    BUNDLE_MANAGEMENT_ERROR("LF-14", "Failed to manage bundle [id=%s] by bundle manager [url=%s]"),
    UNABLE_MODIFY("LF-15", "Failed to modify deployed %s with id = %s"),
    INVALID_INITIAL_DATA("CH-1", "The handler can't start applying command to initial [data=%s] because data is invalid."),
    FAILED_TO_EXECUTE_COMMAND("CH-2", "Failed to execute command %s "),
    FAILED_MODIFY_ENTITY("LF-16", "Failed to modify the %s entity because of connection with deployed offers");

    String statusCode;
    String errorMessage;

    ApplicationErrorStatus(String errorMessage) {
        this("LF-1", errorMessage);
    }

}
