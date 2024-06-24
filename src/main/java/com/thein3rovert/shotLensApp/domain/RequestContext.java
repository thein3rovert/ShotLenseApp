package com.thein3rovert.shotLensApp.domain;

import org.apache.coyote.Request;

public class RequestContext {
    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();

    /**
     * A thread-local variable to store the user ID associated with the current thread.
     * @type {ThreadLocal<Long>}
     */
    private RequestContext() {

    }

    /**
     * Removes the user ID associated with the current thread from the USER_ID thread-local variable.
     */
    public static void start(){
        USER_ID.remove();
    }

    /**
     * Sets the user ID associated with the current thread in the USER_ID thread-local variable. Ensuring all thread have an ID
     * @param {Long} userId - The user ID to set.
     */
    public static void setUserId(Long userId) {
        USER_ID.set(userId);
    }

    /**
     * Retrieves the user ID associated with the current thread from the USER_ID thread-local variable.
     * @returns {Long | undefined} The user ID associated with the current thread, or undefined if not set.
     */
    public static Long getUserId(){
        return USER_ID.get();
    }

}
