package me.j360.trace.collector.core;


import me.j360.trace.collector.core.internal.Nullable;
import me.j360.trace.collector.core.module.Span;

/**
 * Maintains state for a single local span. This means nesting is not supported.
 *
 * <p/>Local spans can be at the following locations in the span tree.
 * <ul>
 *     <li>The root-span of a trace originated by Brave</li>
 *     <li>A child of a server span originated by Brave</li>
 * </ul>
 */
public interface LocalSpanState extends CommonSpanState {

    /**
     * Gets the Span for the local request that was started as part of current request.
     * <p/>
     * Should be thread-aware to support multiple parallel requests.
     * 
     * @return Local request span for current thread.
     */
    @Nullable
    Span getCurrentLocalSpan();

    /**
     * Sets current local span.
     * <p/>
     * Should be thread-aware to support multiple parallel requests.
     * 
     * @param span Local span.
     */
    void setCurrentLocalSpan(Span span);
}
