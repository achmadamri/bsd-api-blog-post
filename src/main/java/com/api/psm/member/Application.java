package com.api.psm.member;

import java.util.List;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.repository.TbProjectRepository;
import com.api.psm.member.db.repository.TbUserOvertimeRepository;
import com.api.psm.member.db.repository.TbUserProjectRepository;
import com.api.psm.member.db.repository.TbUserRepository;
import com.api.psm.member.db.repository.ViewUserAttendanceRepository;
import com.api.psm.member.util.TokenUtil;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	private Logger log = LoggerFactory.getLogger(Application.class);
	
	// HTTP port
	@Value("${http.port}")
	private int httpPort;
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private ViewUserAttendanceRepository viewUserAttendanceRepository;
	
	@Autowired
	private TbUserOvertimeRepository tbUserOvertimeRepository;
	
	@Autowired
	private TbUserProjectRepository tbUserProjectRepository;
	
	@Autowired
	private TbProjectRepository tbProjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		return tomcat;
	}

	private Connector createStandardConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(httpPort);
		return connector;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		log.info("trying to set salt");
		
		List<TbUser> lstTbUser = tbUserRepository.findAll();
		
		for (TbUser tbUser : lstTbUser) {
			log.info("set salt for : " + tbUser.getTbuEmail());
			TokenUtil.keyMap.put(tbUser.getTbuEmail(), tbUser.getTbuTokenSalt());
		}
		
		log.info("set salt done");
		
//		process();
	}
	
//	private void process() {
//		ViewUserAttendance exampleViewUserAttendance = new ViewUserAttendance();
////		exampleViewUserAttendance.setTbuId(1);
//		List<ViewUserAttendance> lstViewUserAttendance =  viewUserAttendanceRepository.findAll(Example.of(exampleViewUserAttendance), Sort.by("tbuId", "tbuaId").ascending());
//		
//		String tbuId = null;
//		
//		String tbuaIdIn = null;
//		String tbuaIdOut = null;
//		
//		String tbuoInTime = null;
//		String tbouOutTime = null;
//		
//		String tbuoInDate = null;
//		String tbuoOutDate = null;
//		
//		for (int i = 0; i < lstViewUserAttendance.size(); i++) {
//			tbuId = lstViewUserAttendance.get(i).getTbuId().toString();
//			
//			if (lstViewUserAttendance.get(i).getTbuaOutTime() != null) {
//				if (lstViewUserAttendance.get(i).getTbuaId().intValue() == 208) {
//					System.out.println();
//				}
//				
//				TbUserProject exampleTbUserProject = new TbUserProject();
//			    exampleTbUserProject.setTbuMemberId(Integer.parseInt(lstViewUserAttendance.get(i).getTbuMemberId()));
//				Optional<TbUserProject> optTbUserProject = tbUserProjectRepository.findOne(Example.of(exampleTbUserProject));
//			    
//			    TbProject exampleTbProject = new TbProject();
//				exampleTbProject.setTbpId(optTbUserProject.get().getTbpId());
//				Optional<TbProject> optTbProject = tbProjectRepository.findOne(Example.of(exampleTbProject));
//				
//				StringUtil stringUtil = new StringUtil();
//				
//				String strStart = (lstViewUserAttendance.get(i).getTbuaInTime() != null ? lstViewUserAttendance.get(i).getTbuaDate() : lstViewUserAttendance.get(i - 1).getTbuaDate()) + " " + optTbProject.get().getTbpShiftStart();
//				Date dateStart = stringUtil.stringToDate(strStart);
//				LocalDateTime localDateStart = dateStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				
//				String strIn = (lstViewUserAttendance.get(i).getTbuaInTime() != null ? lstViewUserAttendance.get(i).getTbuaDate() : lstViewUserAttendance.get(i - 1).getTbuaDate()) + " " + (lstViewUserAttendance.get(i).getTbuaInTime() != null ? lstViewUserAttendance.get(i).getTbuaInTime() : lstViewUserAttendance.get(i - 1).getTbuaInTime());
//				Date dateIn = stringUtil.stringToDate(strIn);
//				LocalDateTime localDateIn = dateIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				
//				String strOut = lstViewUserAttendance.get(i).getTbuaDate() + " " + lstViewUserAttendance.get(i).getTbuaOutTime();
//				Date dateOut = stringUtil.stringToDate(strOut);
//				LocalDateTime localDateOut = dateOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				
//				Duration durationStart = Duration.between(localDateStart, localDateIn);
//				Duration durationWork = Duration.between(localDateIn, localDateOut);
//				
//				int intDurationStart = (int) durationStart.toMinutes();
//				int intDurationWork = ((int) durationWork.toMinutes()) - intDurationStart;
//				int intDurationOvertime = 0;
//				if (intDurationWork > 480) {
//					String status = "";
//				    if (localDateIn.getDayOfWeek() == DayOfWeek.SATURDAY || localDateIn.getDayOfWeek() == DayOfWeek.SUNDAY || localDateOut.getDayOfWeek() == DayOfWeek.SATURDAY || localDateOut.getDayOfWeek() == DayOfWeek.SUNDAY) {
//				    	status = "Off";
//				    } else {
//				    	status = "Work";
//				    }
//				    
//					String strStartOvertimeWork = (lstViewUserAttendance.get(i).getTbuaInTime() != null ? lstViewUserAttendance.get(i).getTbuaDate() : lstViewUserAttendance.get(i - 1).getTbuaDate()) + " " + optTbProject.get().getTbpShiftEnd();
//					Date dateStartOvertimeWork = stringUtil.stringToDate(strStartOvertimeWork);
//					LocalDateTime localDateStartOvertimeWork = dateStartOvertimeWork.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//					
//					String strStartOvertimeOff = (lstViewUserAttendance.get(i).getTbuaInTime() != null ? lstViewUserAttendance.get(i).getTbuaDate() : lstViewUserAttendance.get(i - 1).getTbuaDate()) + " " + (lstViewUserAttendance.get(i).getTbuaInTime() != null ? lstViewUserAttendance.get(i).getTbuaInTime() : lstViewUserAttendance.get(i - 1).getTbuaInTime());
//					Date dateStartOvertimeOff = stringUtil.stringToDate(strStartOvertimeOff);
//				    LocalDateTime localDateStartOvertimeOff = dateStartOvertimeOff.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				    
//				    Duration durationOvertime = null;
//				    if (status.equals("Work")) {
//				    	//Work
//				    	durationOvertime = Duration.between(localDateStartOvertimeWork, localDateOut);
//				    	intDurationOvertime = (int) durationOvertime.toMinutes() - intDurationStart;
//				    } else {
//				    	//Off
//				    	durationOvertime = Duration.between(localDateStartOvertimeOff, localDateOut);
//				    	intDurationOvertime = (int) durationOvertime.toMinutes();
//				    }
//				    
//					tbuaIdOut = lstViewUserAttendance.get(i).getTbuaId().toString();
//					tbuoOutDate = lstViewUserAttendance.get(i).getTbuaDate();
//					tbouOutTime = lstViewUserAttendance.get(i).getTbuaOutTime();
//					
//					if (lstViewUserAttendance.get(i).getTbuaInTime() != null) {
//						tbuaIdIn = lstViewUserAttendance.get(i).getTbuaId().toString();
//						tbuoInDate = lstViewUserAttendance.get(i).getTbuaDate();
//						tbuoInTime = lstViewUserAttendance.get(i).getTbuaInTime();
//					} else {
//						tbuaIdIn = lstViewUserAttendance.get(i - 1).getTbuaId().toString();
//						tbuoInDate = lstViewUserAttendance.get(i - 1).getTbuaDate();
//						tbuoInTime = lstViewUserAttendance.get(i - 1).getTbuaInTime();
//					}
//				    
//				    TbUserOvertime tbUserOvertime = new TbUserOvertime();
//					tbUserOvertime.setTbuoCreateDate(new Date());
//					tbUserOvertime.setTbuoCreateId(0);
//					tbUserOvertime.setTbuId(Integer.valueOf(tbuId));
//					tbUserOvertime.setTbuaIdIn(Integer.valueOf(tbuaIdIn));
//					tbUserOvertime.setTbuaIdOut(Integer.valueOf(tbuaIdOut));
//					tbUserOvertime.setTbuoInDate(tbuoInDate);
//					tbUserOvertime.setTbuoInTime(tbuoInTime);
//					tbUserOvertime.setTbuoOutDate(tbuoOutDate);
//					tbUserOvertime.setTbuoOutTime(tbouOutTime);
//					tbUserOvertime.setTbuoStatus(TbUserOvertime.statusNotApproved);
//				    tbUserOvertime.setTbuoDuration(intDurationOvertime < 0 ? 0 : intDurationOvertime);
//				    
//				    tbUserOvertimeRepository.save(tbUserOvertime);
//				}
//				
//				System.out.println(tbuId + " " + tbuaIdIn + " " + tbuaIdOut + " " + tbuoInDate + " " + tbuoInTime + " " + tbuoOutDate + " " + tbouOutTime);
//			}
//		}
//		
//		System.out.println("end");
//	}
}
