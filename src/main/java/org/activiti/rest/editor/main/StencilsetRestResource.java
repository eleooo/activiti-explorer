/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.rest.editor.main;

import java.io.InputStream;
import java.nio.charset.Charset;

import org.activiti.engine.ActivitiException;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tijs Rademakers
 */
@RestController
public class StencilsetRestResource {

	@RequestMapping(value = "/editor/stencilset", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody String getStencilset() {
		InputStream stencilsetStream = this.getClass().getClassLoader()
				.getResourceAsStream("stencilset.json");
		try {
			String result = IOUtils.toString(stencilsetStream,
					Charset.forName("UTF-8"));
			return result;
		} catch (Exception e) {
			throw new ActivitiException("Error while loading stencil set", e);
		}
	}
	
	public static void main(String[] args) {
		InputStream stencilsetStream = StencilsetRestResource.class.getClassLoader()
				.getResourceAsStream("stencilset.json");
		try {
			String result = IOUtils.toString(stencilsetStream,
					Charset.forName("UTF-8"));
			System.out.println("stencilset:" + result);
		} catch (Exception e) {
			throw new ActivitiException("Error while loading stencil set", e);
		}
	}
}
