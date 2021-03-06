/*
 * Copyright 2017 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.rmapproject.loader.camel.impl.file;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.Message;

public class EnhancedZipSplitter
        implements Expression {

    public Object evaluate(Exchange exchange) {
        final Message inputMessage = exchange.getIn();
        return new EnhancedZipIterator(inputMessage);
    }

    @Override
    public <T> T evaluate(Exchange exchange, Class<T> type) {
        final Object result = evaluate(exchange);
        return exchange.getContext().getTypeConverter().convertTo(type, exchange, result);
    }
}
