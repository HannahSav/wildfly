/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.logging.resolvers;

import static org.jboss.as.logging.Logging.createOperationFailure;

import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.logging.logging.LoggingLogger;
import org.jboss.dmr.ModelNode;
import org.jboss.logmanager.handlers.AsyncHandler.OverflowAction;

/**
 * Date: 15.12.2011
 *
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */ /*
 * Resolvers
 */
public class OverflowActionResolver implements ModelNodeResolver<String> {

    public static final OverflowActionResolver INSTANCE = new OverflowActionResolver();

    private OverflowActionResolver() {
    }

    @Override
    public String resolveValue(final OperationContext context, final ModelNode value) throws OperationFailedException {
        try {
            return OverflowAction.valueOf(value.asString()).toString();
        } catch (IllegalArgumentException e) {
            throw createOperationFailure(LoggingLogger.ROOT_LOGGER.invalidOverflowAction(value.asString()));
        }
    }
}
