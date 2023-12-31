/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.velocity;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.template.AbstractTemplateViewResolverProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * {@link ConfigurationProperties} for configuring Velocity.
 *
 * @author Andy Wilkinson
 * @Modifier sadeychai on 2023/08/08
 *           support layout view resolver
 * @since 1.1.0
 * @deprecated as of 1.4 following the deprecation of Velocity support in Spring Framework
 *         4.3
 */
@ConfigurationProperties(prefix = "spring.velocity")
public class VelocityProperties extends AbstractTemplateViewResolverProperties {

    public static final String DEFAULT_RESOURCE_LOADER_PATH = "classpath:/templates/";

    public static final String DEFAULT_PREFIX = "";

    public static final String DEFAULT_SUFFIX = ".vm";

    /**
     * Name of the DateTool helper object to expose in the Velocity context of the view.
     */
    private String dateToolAttribute;

    /**
     * Name of the NumberTool helper object to expose in the Velocity context of the view.
     */
    private String numberToolAttribute;

    /**
     * Additional velocity properties.
     */
    private Map<String, String> properties = new HashMap<String, String>();

    /**
     * Template path.
     */
    private String resourceLoaderPath = DEFAULT_RESOURCE_LOADER_PATH;

    /**
     * Velocity Toolbox config location, for example "/WEB-INF/toolbox.xml". Automatically
     * loads a Velocity Tools toolbox definition file and expose all defined tools in the
     * specified scopes.
     */
    private String toolboxConfigLocation;

    /**
     * Prefer file system access for template loading. File system access enables hot
     * detection of template changes.
     */
    private boolean preferFileSystemAccess = true;

    /**
     * 是否支持layout
     */
    private boolean layoutViewResolver = false;
    /**
     * layout url
     *
     * @see org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver#setLayoutUrl(String)
     */
    private String layoutUrl;
    /**
     * layoutKey
     *
     * @see org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver#setLayoutKey(String)
     */
    private String layoutKey;
    /**
     * screenContentKey
     *
     * @see org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver#setScreenContentKey(String)
     */
    private String screenContentKey;


    public VelocityProperties() {
        super(DEFAULT_PREFIX, DEFAULT_SUFFIX);
    }

    public String getDateToolAttribute() {
        return this.dateToolAttribute;
    }

    public void setDateToolAttribute(String dateToolAttribute) {
        this.dateToolAttribute = dateToolAttribute;
    }

    public String getNumberToolAttribute() {
        return this.numberToolAttribute;
    }

    public void setNumberToolAttribute(String numberToolAttribute) {
        this.numberToolAttribute = numberToolAttribute;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getResourceLoaderPath() {
        return this.resourceLoaderPath;
    }

    public void setResourceLoaderPath(String resourceLoaderPath) {
        this.resourceLoaderPath = resourceLoaderPath;
    }

    public String getToolboxConfigLocation() {
        return this.toolboxConfigLocation;
    }

    public void setToolboxConfigLocation(String toolboxConfigLocation) {
        this.toolboxConfigLocation = toolboxConfigLocation;
    }

    public boolean isPreferFileSystemAccess() {
        return this.preferFileSystemAccess;
    }

    public void setPreferFileSystemAccess(boolean preferFileSystemAccess) {
        this.preferFileSystemAccess = preferFileSystemAccess;
    }

    public boolean isLayoutViewResolver() {
        return layoutViewResolver;
    }

    public void setLayoutViewResolver(boolean layoutViewResolver) {
        this.layoutViewResolver = layoutViewResolver;
    }

    public String getLayoutUrl() {
        return layoutUrl;
    }

    public void setLayoutUrl(String layoutUrl) {
        this.layoutUrl = layoutUrl;
    }

    public String getLayoutKey() {
        return layoutKey;
    }

    public void setLayoutKey(String layoutKey) {
        this.layoutKey = layoutKey;
    }

    public String getScreenContentKey() {
        return screenContentKey;
    }

    public void setScreenContentKey(String screenContentKey) {
        this.screenContentKey = screenContentKey;
    }

    @Override
    public void applyToMvcViewResolver(Object viewResolver) {
        super.applyToMvcViewResolver(viewResolver);
        VelocityViewResolver resolver = (VelocityViewResolver) viewResolver;
        resolver.setToolboxConfigLocation(getToolboxConfigLocation());
        resolver.setDateToolAttribute(getDateToolAttribute());
        resolver.setNumberToolAttribute(getNumberToolAttribute());
        if (isLayoutViewResolver() && resolver instanceof VelocityLayoutViewResolver) {
            ((VelocityLayoutViewResolver) resolver).setLayoutUrl(getLayoutUrl());
            ((VelocityLayoutViewResolver) resolver).setLayoutKey(getLayoutKey());
            ((VelocityLayoutViewResolver) resolver).setScreenContentKey(getScreenContentKey());
        }
    }

}
